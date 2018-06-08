package com.ncs.web.wx.mvc;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.service.MessageHandler;
import com.ncs.web.wx.service.MessageHandlerFactory;
import com.ncs.web.wx.service.WxService;

/**
 * 微信接入控制器，接口规范参见{@link http://mp.weixin.qq.com/wiki/home/index.html}
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月5日 下午2:56:58
 */
public class WechatController extends WebApplicationObjectSupport implements Controller, InitializingBean {

	private WxService wxService;
	private MessageHandlerFactory handlerFactory;

	public WxService getWxService() {
		return wxService;
	}

	public void setWxService(WxService wxService) {
		this.wxService = wxService;
	}

	public MessageHandlerFactory getHandlerFactory() {
		return handlerFactory;
	}

	public void setHandlerFactory(MessageHandlerFactory handlerFactory) {
		this.handlerFactory = handlerFactory;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(wxService, "wxService is required!");
		Assert.notNull(handlerFactory, "handlerFactory is required!");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String method = req.getMethod();
		if ("GET".equalsIgnoreCase(method)) {
			String signature = req.getParameter("signature");// 微信加密签名
			String timestamp = req.getParameter("timestamp");// 时间戳
			String nonce = req.getParameter("nonce"); // 随机数
			String echostr = req.getParameter("echostr"); // 随机字符串
			if (!StringUtils.isEmpty(signature) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(nonce)) {
				handleAuthRequest(signature, timestamp, nonce, echostr, resp);
				return null;
			}
			String ncsoaOpenId = req.getParameter("ncsoaOpenId");
			if (!StringUtils.isEmpty(ncsoaOpenId)) {
				String weiXinHeadImgUrl = wxService.getWeiXinHeadImgUrl(ncsoaOpenId);
				return JsonView.Render(weiXinHeadImgUrl, resp);
			}
		}
		handleMessageRequest(req, resp);
		return null;
	}

	protected void handleAuthRequest(String signature, String timestamp, String nonce, String echostr,
			HttpServletResponse resp) throws IOException {
		if (wxService.checkSignature(signature, timestamp, nonce)) {
			// 验证通过
			logger.debug("checkSignature success!");
			sendMessage(echostr, resp);
		} else {
			// 失败
			logger.debug("checkSignature failure!");
			sendMessage("", resp);
		}
	}

	protected void handleMessageRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ServletInputStream in = req.getInputStream();
		String xml = in == null ? "" : IOUtils.toString(in, "UTF-8");
		if (xml.length() == 0) {
			logger.debug("input message is empty!");
			sendMessage("", resp);
			return;
		}
		InputMessage inputMsg = null;
		try {
			JAXBContext context = JAXBContext.newInstance(InputMessage.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			inputMsg = (InputMessage) unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			logger.debug("parse input message error", e);
			sendMessage("", resp);
			return;
		}
		MessageHandler handler = handlerFactory.getMessageHandler(inputMsg);
		OutputMessage outputMsg = handler.handle(inputMsg);
		if (outputMsg != null) {
			outputMsg.setCreateTime(System.currentTimeMillis());
			outputMsg.setFromUserName(inputMsg.getToUserName());
			outputMsg.setToUserName(inputMsg.getFromUserName());
		}
		sendMessage(outputMsg, resp);
	}

	/**
	 * 发送字符串响应信息
	 * 
	 * @param message
	 * @param resp
	 * @throws IOException
	 */
	protected void sendMessage(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain; charset=UTF-8");
		Writer writer = new OutputStreamWriter(resp.getOutputStream());
		writer.write(message);
		writer.flush();
	}

	/**
	 * 发送xml响应信息
	 * 
	 * @param message
	 * @param resp
	 * @throws IOException
	 */
	protected void sendMessage(OutputMessage message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/xml; charset=UTF-8");
		Writer writer = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
		String xml = message == null ? "" : message.toXML();
		writer.write(xml);
		writer.flush();
	}
}
