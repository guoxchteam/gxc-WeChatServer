package com.ncs.web.wx.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.MsgType;
import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.service.NormalMessageHandler;

/**
 * 普通消息处理器的基础类
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午3:44:41
 */
public abstract class AbstractNormalMessageHandler<M extends NormalMessage> implements NormalMessageHandler<M> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	@Override
	public M getNormalMessage(InputMessage message) {
		if (message == null) {
			return null;
		}
		String msgType = message.getMsgType();
		if (msgType.equals(MsgType.Text.toString())) {
			// 处理文本消息
			return (M) message.toTextInputMessage();
		} else if (msgType.equals(MsgType.Image.toString())) {
			// 处理图片消息
			return (M) message.toImageInputMessage();
		} else if (msgType.equals(MsgType.Voice.toString())) {
			// 处理语音消息
			return (M) message.toVoiceInputMessage();
		} else if (msgType.equals(MsgType.Video.toString())) {
			// 处理视频消息
			return (M) message.toVideoInputMessage();
		} else if (msgType.equals(MsgType.ShortVideo.toString())) {
			// 处理小视频消息
			return (M) message.toShortVideoInputMessage();
		} else if (msgType.equals(MsgType.Location.toString())) {
			// 处理地理位置消息
			return (M) message.toLocationInputMessage();
		} else if (msgType.equals(MsgType.Link.toString())) {
			// 处理链接消息
			return (M) message.toLinkInputMessage();
		} else {
			return getExtendedNormalMessage(msgType, message);
		}
	}

	/**
	 * 转换扩展类型的消息
	 * 
	 * @param msgType
	 * @param message
	 * @return
	 */
	protected M getExtendedNormalMessage(String msgType, InputMessage message) {
		return null;
	}

}
