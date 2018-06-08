package com.ncs.web.wx.service;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.normal.NormalMessage;

/**
 * ��ͨ��Ϣ������
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��8�� ����2:07:12
 */
public interface NormalMessageHandler<M extends NormalMessage> {

	/**
	 * ��΢����Ϣת��Ϊ�������ɴ������Ϣ
	 * @param message
	 * @return
	 */
	public M getNormalMessage(InputMessage message);
	
	/**
	 * ����΢����Ϣ
	 * 
	 * @param message
	 *            ���������Ϣ
	 * @return ���ɵ���Ӧ��Ϣ
	 */
	public OutputMessage handle(M message);
}
