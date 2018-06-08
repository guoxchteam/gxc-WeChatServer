package com.ncs.web.wx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.event.EventMessage;

/**
 * 事件消息处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午2:12:06
 */
public class EventMessageHandlerAdapter<M extends EventMessage> implements MessageHandler {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private EventMessageHandler<M> messageHandler;

	public EventMessageHandlerAdapter() {
		super();
	}

	public EventMessageHandlerAdapter(EventMessageHandler<M> messageHandler) {
		super();
		setMessageHandler(messageHandler);
	}

	public EventMessageHandler<M> getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(EventMessageHandler<M> messageHandler) {
		this.messageHandler = messageHandler;
	}

	@Override
	public OutputMessage handle(InputMessage message) {
		if (message == null || messageHandler == null) {
			return null;
		}
		M msg = messageHandler.getEventMessage(message);
		return messageHandler.handle(msg);
	}

}
