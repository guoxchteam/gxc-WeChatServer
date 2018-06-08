package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.event.EventMessage;

/**
 * �¼���Ϣ������
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��8�� ����2:07:52
 */
public interface EventMessageHandler<M extends EventMessage> {

	/**
	 * ��΢����Ϣת��Ϊ�������ɴ������Ϣ
	 * @param message
	 * @return
	 */
	public M getEventMessage(InputMessage message);
	
	/**
	 * ����΢����Ϣ
	 * 
	 * @param message
	 *            ���������Ϣ
	 * @return ���ɵ���Ӧ��Ϣ
	 */
	public OutputMessage handle(M message);
}
