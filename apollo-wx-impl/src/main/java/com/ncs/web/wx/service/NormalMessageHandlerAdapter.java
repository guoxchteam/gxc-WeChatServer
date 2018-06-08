package com.ncs.web.wx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.normal.NormalMessage;

/**
 * 普通消息处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午2:12:06
 */
public class NormalMessageHandlerAdapter<M extends NormalMessage> implements MessageHandler {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private NormalMessageHandler<M> messageHandler;

	public NormalMessageHandlerAdapter() {
		super();
	}

	public NormalMessageHandlerAdapter(NormalMessageHandler<M> normalMessageHandler) {
		super();
		setMessageHandler(normalMessageHandler);
	}

	public NormalMessageHandler<M> getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(NormalMessageHandler<M> normalMessageHandler) {
		this.messageHandler = normalMessageHandler;
	}

	@Override
	public OutputMessage handle(InputMessage message) {
		if(message == null || messageHandler == null) {
			return null;
		}
		M msg = messageHandler.getNormalMessage(message);
		return messageHandler.handle(msg);
	}

}
