package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.event.EventMessage;

/**
 * 事件消息处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午2:07:52
 */
public interface EventMessageHandler<M extends EventMessage> {

	/**
	 * 将微信消息转换为处理器可处理的消息
	 * @param message
	 * @return
	 */
	public M getEventMessage(InputMessage message);
	
	/**
	 * 处理微信消息
	 * 
	 * @param message
	 *            待处理的消息
	 * @return 生成的响应信息
	 */
	public OutputMessage handle(M message);
}
