package com.ncs.web.wx.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.normal.VoiceInputMessage;
import com.ncs.web.wx.message.output.TextOutputMessage;

/**
 * 简单图片的处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午4:04:36
 */
public class VoiceMessageHandler extends AbstractNormalMessageHandler<NormalMessage> {
	private ObjectMapper objectMapper = new ObjectMapper();
	private String touser = "oN6YM0sLpTWBF5uCAlypANgf-uvc";

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
		if (message instanceof VoiceInputMessage) {
			VoiceInputMessage imagemessage = (VoiceInputMessage) message;
			out.setContent("消息已收到：" + imagemessage.getRecognition());
		}
		return out;
	}

}
