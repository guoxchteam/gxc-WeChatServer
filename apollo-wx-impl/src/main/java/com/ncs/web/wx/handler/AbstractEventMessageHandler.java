package com.ncs.web.wx.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.event.EventMessage;
import com.ncs.web.wx.service.EventMessageHandler;

/**
 * �¼���Ϣ�������Ļ�����
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��8�� ����3:44:41
 */
public abstract class AbstractEventMessageHandler<M extends EventMessage> implements EventMessageHandler<M> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	@Override
	public M getEventMessage(InputMessage message) {
		if (message == null) {
			return null;
		} // ��ȡ�¼�����
		String event = message.getEvent();

		// �Զ���˵��¼�
		if (event.equals(EventType.Click.toString())) {
			// ����˵���ȡ��Ϣʱ���¼�����
			return (M) message.toClickEventMessage();
		} else if (event.equals(EventType.View.toString())) {
			// ����˵���ת����ʱ���¼�����
			return (M) message.toViewEventMessage();
		} else if (event.equals(EventType.Subscribe.toString())) {
			// ��ע�¼�
			return (M) message.toSubscribeEventMessage();
		} else if (event.equals(EventType.Unsubscribe.toString())) {
			// ȡ����ע�¼�
			return (M) message.toUnSubscribeEventMessage();
		} else if (event.equals(EventType.Scan.toString())) {
			// ɨ���������ά���¼�
			// ��ȡ�¼�KEYֵ���ж��Ƿ��ע
			String eventKey = message.getEventKey();
			if (eventKey.startsWith("qrscene_")) {
				// �û�δ��עʱ�����й�ע����¼�����
				return (M) message.toQrsceneSubscribeEventMessage();
			} else {
				// �û��ѹ�עʱ���¼�����
				return (M) message.toQrsceneScanEventMessage();
			}
		} else if (event.equals(EventType.Location.toString())) {
			// �ϱ�����λ���¼�
			return (M) message.toLocationEventMessage();
		} else if (event.equals(EventType.Scancode_Push.toString())) {
			// ɨ�����¼����¼�����
			return (M) message.toScanCodePushEventMessage();
		} else if (event.equals(EventType.Scancode_Waitmsg.toString())) {
			// ɨ�����¼��ҵ�������Ϣ�����С���ʾ����¼�����
			return (M) message.toScanCodeWaitMsgEventMessage();
		} else if (event.equals(EventType.Pic_Sysphoto.toString())) {
			// ����ϵͳ���շ�ͼ���¼�����
			return (M) message.toPicSysPhotoEventMessage();
		} else if (event.equals(EventType.Pic_Photo_OR_Album.toString())) {
			// �������ջ�����ᷢͼ���¼�����
			return (M) message.toPicPhotoOrAlbumEventMessage();
		} else if (event.equals(EventType.Pic_Weixin.toString())) {
			// ����΢����ᷢͼ�����¼�����
			return (M) message.toPicWeixinEventMessage();
		} else if (event.equals(EventType.Location_Select.toString())) {
			// ��������λ��ѡ�������¼�����
			return (M) message.toLocationSelectEventMessage();
		} else {
			return getExtendedEventMessage(event, message);
		}
	}

	/**
	 * ת����չ���͵���Ϣ
	 * 
	 * @param event
	 * @param message
	 * @return
	 */
	protected M getExtendedEventMessage(String event, InputMessage message) {
		return null;
	}

}
