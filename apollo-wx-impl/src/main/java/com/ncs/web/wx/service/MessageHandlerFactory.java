package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;

/**
 * 微信消息处理器工厂
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 上午11:31:43
 */
public interface MessageHandlerFactory {

	/**
	 * 返回用于处理指定消息的消息处理器
	 * 
	 * @param message
	 * @return
	 */
	public MessageHandler getMessageHandler(InputMessage message);
}
