package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;

/**
 * ΢����Ϣ����������
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��8�� ����11:31:43
 */
public interface MessageHandlerFactory {

	/**
	 * �������ڴ���ָ����Ϣ����Ϣ������
	 * 
	 * @param message
	 * @return
	 */
	public MessageHandler getMessageHandler(InputMessage message);
}
