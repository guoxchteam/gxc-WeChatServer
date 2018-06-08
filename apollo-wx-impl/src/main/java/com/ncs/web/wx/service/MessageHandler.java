package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;

/**
 * ΢����Ϣ������
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��5�� ����2:58:08
 */
public interface MessageHandler {

	/**
	 * ����΢����Ϣ
	 * 
	 * @param message
	 *            ���������Ϣ
	 * @return ���ɵ���Ӧ��Ϣ
	 */
	public OutputMessage handle(InputMessage message);
}
