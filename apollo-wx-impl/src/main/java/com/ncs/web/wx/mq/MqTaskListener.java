package com.ncs.web.wx.mq;

import java.io.Serializable;
import java.util.Map;

public interface MqTaskListener {
	/**
	 * 接收到维护任务消息时执行的回调函数
	 * 
	 * @param message
	 */
	void handleMessage(Map<String, Serializable> message);
}
