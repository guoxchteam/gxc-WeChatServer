package com.ncs.web.wx.service;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncs.web.wx.menu.SingleButton;
import com.ncs.web.wx.message.TemplateMsg;
import com.ncs.web.wx.util.ErrorUtils;

/**
 * 微信接口服务的缺省实现
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月5日 下午3:11:06
 */
public class WxServiceImpl implements WxService, ApplicationContextAware, DisposableBean, InitializingBean {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private String token;
	private String appId;
	private String appSecret;
	private ApplicationContext applicationContext;
	private Resource baseDir;
	private File base;
	private boolean strictSsl;
	private CloseableHttpClient httpClient;
	private ObjectMapper objectMapper;
	private long flushTime = 60;

	private String accessTokenUrl;

	private AccessToken accessToken;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public Resource getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(Resource baseDir) {
		this.baseDir = baseDir;
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void destroy() throws Exception {
		if (httpClient != null) {
			httpClient.close();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(token, "token is required!");
		Assert.notNull(appId, "appId is required!");
		Assert.notNull(appSecret, "appSecret is required!");

		logger.debug("Token: {}", token);
		logger.debug("AppId: {}", appId);
		logger.debug("AppSecret: {}", appSecret);
		if (baseDir == null) {
			baseDir = getApplicationContext().getResource("/WEB-INF");
		}
		base = baseDir.getFile();
		if (!base.exists()) {
			base.mkdirs();
		}
		if (httpClient == null) {
			if (strictSsl) {
				httpClient = HttpClients.createDefault();
			} else {
				SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(new TrustStrategy() {
					@Override
					public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
						return true;
					}
				}).build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
						NoopHostnameVerifier.INSTANCE);
				httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			}
		}
		if (StringUtils.isEmpty(accessTokenUrl)) {
			accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId
					+ "&secret=" + appSecret;
		}
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		accessToken = loadAccessToken();
	}

	@Override
	public boolean checkSignature(String signature, String timestamp, String nonce) {
		if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
			return false;
		}
		// 1.将token、timestamp、nonce三个参数进行字典序排序
		String[] values = { token, timestamp, nonce };
		Arrays.sort(values);
		// 2.将三个参数字符串拼接成一个字符串进行sha1加密
		String value = values[0] + values[1] + values[2];
		String sign = DigestUtils.sha1Hex(value);
		// 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return signature.equals(sign);
	}

	@Override
	public AccessToken getAccessToken() {
		if (isExpired(accessToken)) {
			AccessToken token;
			try {
				token = acquireAccessToken();
			} catch (IOException e) {
				throw new RuntimeException("acquire access token failure!", e);
			}
			setAccessToken(token);
		}
		return accessToken;
	}

	@Override
	public void setAccessToken(AccessToken token) {
		if (token == null) {
			File file = new File(base, "token.json");
			file.delete();
		} else {
			File newFile = null;
			try {
				String json = objectMapper.writeValueAsString(token);
				File oldFile = new File(base, "token.json");
				newFile = new File(base, "token.new.json");
				FileUtils.writeStringToFile(newFile, json, "UTF-8");
				oldFile.delete();
				newFile.renameTo(oldFile);
				newFile = null;
			} catch (IOException e) {
				FileUtils.deleteQuietly(newFile);
				logger.warn("error on save access token", e);
			}
		}
		accessToken = token;
	}

	@Override
	public void createMenu(SingleButton[] buttons) throws IOException {
		AccessToken token = getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + token.getToken();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("button", buttons);
		String value = objectMapper.writeValueAsString(map);
		HttpPost httpost = new HttpPost(url);
		httpost.setEntity(new StringEntity(value, "UTF-8"));
		JsonNode json = execRequest(httpost);
		JsonNode node = json.get("errcode");
		int status = node == null || node.isNull() ? 0 : node.intValue();
		if (status == 0) {
			return;
		}
		logger.warn("create menu error: {}", ErrorUtils.getCause(status));
		node = json.get("errmsg");
		String msg = node == null || node.isNull() ? "" : node.asText();
		throw new IOException("createMenu failure: " + status + " - " + msg);
	}

	@Override
	public JsonNode getAllPrivateTemplate() throws Exception {
		AccessToken token = getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="
				+ token.getToken();
		HttpGet httpGet = new HttpGet(url);
		JsonNode json = execRequest(httpGet);
		JsonNode node = json.get("errcode");
		int status = node == null || node.isNull() ? 0 : node.intValue();
		if (status == 0) {
			return json;
		}
		logger.warn("getTemplateId error: {}", ErrorUtils.getCause(status));
		node = json.get("errmsg");
		String msg = node == null || node.isNull() ? "" : node.asText();
		throw new Exception("getTemplateId failure: " + status + " - " + msg);
	}

	@Override
	public void sendTemplateMsg(TemplateMsg wechatTemplateMsg) throws Exception {
		AccessToken token = getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token.getToken();
		String value = objectMapper.writeValueAsString(wechatTemplateMsg);
		HttpPost httpost = new HttpPost(url);
		httpost.setEntity(new StringEntity(value, "UTF-8"));
		JsonNode json = execRequest(httpost);
		JsonNode node = json.get("errcode");
		int status = node == null || node.isNull() ? 0 : node.intValue();
		if (status == 0) {
			return;
		}
		logger.warn("sendTemplateMsg error: {}", ErrorUtils.getCause(status));
		node = json.get("errmsg");
		String msg = node == null || node.isNull() ? "" : node.asText();
		throw new Exception("sendTemplateMsg failure: " + status + " - " + msg);
	}

	protected AccessToken loadAccessToken() {
		File file = new File(base, "token.json");
		if (!file.exists()) {
			return null;
		}
		try {
			String json = FileUtils.readFileToString(file, "UTF-8");
			AccessToken token = objectMapper.readValue(json, AccessToken.class);
			return isExpired(token) ? null : token;
		} catch (IOException e) {
			logger.warn("read access token file error", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	protected AccessToken acquireAccessToken() throws IOException {
		JsonNode json = execRequest(new HttpGet(accessTokenUrl));
		if (json == null || json.isNull()) {
			throw new IOException("acquire access token failure");
		}
		JsonNode node = json.get("errcode");
		int status = node == null || node.isNull() ? 0 : node.intValue();
		if (status != 0) {
			logger.warn("acquire access token error: {}", ErrorUtils.getCause(status));
			node = json.get("errmsg");
			String msg = node == null || node.isNull() ? "" : node.asText();
			throw new IOException("acquire access token failure: " + status + " - " + msg);
		}
		node = json.get("access_token");
		String token = node == null || node.isNull() ? null : node.asText();
		node = json.get("expires_in");
		long lifetime = node == null || node.isNull() ? 0 : node.asLong();
		if (StringUtils.isEmpty(token) || lifetime <= 0) {
			logger.warn("illegal access token!");
			throw new IOException("illegal access token!");
		} else {
			lifetime = lifetime * 1000;
			return new AccessToken(token, System.currentTimeMillis() + lifetime);
		}
	}

	protected JsonNode execRequest(HttpUriRequest request) {
		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}
		};
		try {
			String json = httpClient.execute(request, responseHandler);
			return objectMapper.readTree(json);
		} catch (IOException e) {
			logger.warn("execute request error!", e);
			return null;
		}
	}

	protected boolean isExpired(AccessToken token) {
		if (token == null) {
			return true;
		}
		long time = System.currentTimeMillis();
		if (time >= token.getExpireTime()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getWeiXinHeadImgUrl(String openId) throws Exception {
		AccessToken token = getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + token.getToken() + "&openid="
				+ openId + "&lang=zh_CN";
		HttpGet httpGet = new HttpGet(url);
		JsonNode json = execRequest(httpGet);
		JsonNode node = json.get("errcode");
		int status = node == null || node.isNull() ? 0 : node.intValue();
		if (status == 0) {
			JsonNode jsonNode = json.get("headimgurl");
			String headimgurl = jsonNode == null || jsonNode.isNull() ? "" : jsonNode.asText();
			return headimgurl;
		}
		logger.warn("getWeiXinHeadImgUrl error: {}", ErrorUtils.getCause(status));
		node = json.get("errmsg");
		String msg = node == null || node.isNull() ? "" : node.asText();
		throw new Exception("getWeiXinHeadImgUrl failure: " + status + " - " + msg);
	}
}
