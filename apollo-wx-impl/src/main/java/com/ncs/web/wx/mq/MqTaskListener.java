package com.ncs.web.wx.mq;

import java.io.Serializable;
import java.util.Map;

public interface MqTaskListener {
	/**
	 * ���յ�ά��������Ϣʱִ�еĻص�����
	 * 
	 * @param message
	 */
	void handleMessage(Map<String, Serializable> message);
}
