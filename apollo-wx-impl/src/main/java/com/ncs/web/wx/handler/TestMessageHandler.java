package com.ncs.web.wx.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncs.web.wx.jpa.entity.TextMessageEntity;
import com.ncs.web.wx.jpa.service.TextMessageService;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.normal.TextInputMessage;
import com.ncs.web.wx.message.output.TextOutputMessage;

/**
 * 简单回应的处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午4:04:36
 */
public class TestMessageHandler extends AbstractNormalMessageHandler<NormalMessage> {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private ObjectMapper objectMapper = new ObjectMapper();
	private String touser = "oN6YM0sLpTWBF5uCAlypANgf-uvc";
	@Autowired
	private TextMessageService textMessageService;

	public TextMessageService getTextMessageService() {
		return textMessageService;
	}

	public void setTextMessageService(TextMessageService textMessageService) {
		this.textMessageService = textMessageService;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public OutputMessage handle(NormalMessage message) {
		TextOutputMessage out = new TextOutputMessage();
		out.setContent("消息已收到！");
		if (message instanceof TextInputMessage) {
			TextInputMessage textmessage = (TextInputMessage) message;
			Long msgId = textmessage.getMsgId();
			String toUserName = textmessage.getToUserName();
			String fromUserName = textmessage.getFromUserName();
			Long createTime = textmessage.getCreateTime();
			String content = textmessage.getContent();
			String msgType = textmessage.getMsgType();
			TextMessageEntity textMessageEntity = new TextMessageEntity(msgId, msgType, toUserName, fromUserName, msgId,
					createTime, content);
			try {
				long id = textMessageService.Create(textMessageEntity);
				logger.debug("Create is " + id);
			} catch (Exception e) {
				logger.debug("Exception is " + e.getLocalizedMessage(), e);
				out.setContent("消息已收到：" + textmessage.getContent());
				return out;
			}
		}
		return out;
	}

}
