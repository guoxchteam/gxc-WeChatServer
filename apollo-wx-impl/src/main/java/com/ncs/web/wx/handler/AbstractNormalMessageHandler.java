package com.ncs.web.wx.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.MsgType;
import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.service.NormalMessageHandler;

/**
 * ��ͨ��Ϣ�������Ļ�����
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��8�� ����3:44:41
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
			// �����ı���Ϣ
			return (M) message.toTextInputMessage();
		} else if (msgType.equals(MsgType.Image.toString())) {
			// ����ͼƬ��Ϣ
			return (M) message.toImageInputMessage();
		} else if (msgType.equals(MsgType.Voice.toString())) {
			// ����������Ϣ
			return (M) message.toVoiceInputMessage();
		} else if (msgType.equals(MsgType.Video.toString())) {
			// ������Ƶ��Ϣ
			return (M) message.toVideoInputMessage();
		} else if (msgType.equals(MsgType.ShortVideo.toString())) {
			// ����С��Ƶ��Ϣ
			return (M) message.toShortVideoInputMessage();
		} else if (msgType.equals(MsgType.Location.toString())) {
			// �������λ����Ϣ
			return (M) message.toLocationInputMessage();
		} else if (msgType.equals(MsgType.Link.toString())) {
			// ����������Ϣ
			return (M) message.toLinkInputMessage();
		} else {
			return getExtendedNormalMessage(msgType, message);
		}
	}

	/**
	 * ת����չ���͵���Ϣ
	 * 
	 * @param msgType
	 * @param message
	 * @return
	 */
	protected M getExtendedNormalMessage(String msgType, InputMessage message) {
		return null;
	}

}
