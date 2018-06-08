package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;

/**
 * 微信消息处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月5日 下午2:58:08
 */
public interface MessageHandler {

	/**
	 * 处理微信消息
	 * 
	 * @param message
	 *            待处理的消息
	 * @return 生成的响应信息
	 */
	public OutputMessage handle(InputMessage message);
}
