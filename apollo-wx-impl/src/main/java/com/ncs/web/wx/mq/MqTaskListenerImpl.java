package com.ncs.web.wx.mq;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import com.ncs.web.wx.message.TemplateMsg;
import com.ncs.web.wx.service.WxService;

public class MqTaskListenerImpl implements MqTaskListener, ApplicationContextAware, InitializingBean {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private ApplicationContext applicationContext;
	private WxService wxService;

	public WxService getWxService() {
		return wxService;
	}

	public void setWxService(WxService wxService) {
		this.wxService = wxService;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(wxService, "wxService is required!");
	}

	@Override
	public void handleMessage(Map<String, Serializable> data) {
		TreeMap<String,String> treeMap = new TreeMap<String,String>();
		Set<String> keySet = data.keySet();
		for (String key : keySet) {
			String value = (String)data.get(key);
			//System.out.println(key+"------"+value);
			treeMap.put(key, value);
		}
		// ≤‚ ‘œ˚œ¢
		TreeMap<String, TreeMap<String, String>> params = new TreeMap<String, TreeMap<String, String>>();
		params.put("first", TemplateMsg.item(treeMap.get("title"), "#000000"));
		params.put("keyword1", TemplateMsg.item(treeMap.get("title"), "#000000"));
		params.put("keyword2", TemplateMsg.item(treeMap.get("sendDate"), "#000000"));
		params.put("remark", TemplateMsg.item(treeMap.get("body"), "#000000"));
		TemplateMsg wechatTemplateMsg = new TemplateMsg();
		wechatTemplateMsg.setTemplate_id(treeMap.get("templateId"));
		wechatTemplateMsg.setTouser(treeMap.get("touser"));
		wechatTemplateMsg.setUrl(treeMap.get("url"));
		wechatTemplateMsg.setData(params);
		try {
			wxService.sendTemplateMsg(wechatTemplateMsg);
		} catch (Exception e) {
			//logger.warn("sendTemplateMsg failed", e);
			return;
		}
	}

}
