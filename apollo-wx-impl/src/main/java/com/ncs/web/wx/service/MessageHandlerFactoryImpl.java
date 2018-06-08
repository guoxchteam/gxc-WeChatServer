package com.ncs.web.wx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.MsgType;
import com.ncs.web.wx.message.event.ClickEventMessage;
import com.ncs.web.wx.message.event.LocationEventMessage;
import com.ncs.web.wx.message.event.LocationSelectEventMessage;
import com.ncs.web.wx.message.event.PicPhotoOrAlbumEventMessage;
import com.ncs.web.wx.message.event.PicSysPhotoEventMessage;
import com.ncs.web.wx.message.event.PicWeixinEventMessage;
import com.ncs.web.wx.message.event.QrsceneScanEventMessage;
import com.ncs.web.wx.message.event.QrsceneSubscribeEventMessage;
import com.ncs.web.wx.message.event.ScanCodePushEventMessage;
import com.ncs.web.wx.message.event.ScanCodeWaitMsgEventMessage;
import com.ncs.web.wx.message.event.SubscribeEventMessage;
import com.ncs.web.wx.message.event.UnSubscribeEventMessage;
import com.ncs.web.wx.message.event.ViewEventMessage;
import com.ncs.web.wx.message.normal.ImageInputMessage;
import com.ncs.web.wx.message.normal.LinkInputMessage;
import com.ncs.web.wx.message.normal.LocationInputMessage;
import com.ncs.web.wx.message.normal.ShortVideoInputMessage;
import com.ncs.web.wx.message.normal.TextInputMessage;
import com.ncs.web.wx.message.normal.VideoInputMessage;
import com.ncs.web.wx.message.normal.VoiceInputMessage;

/**
 * ΢����Ϣ������������ȱʡʵ��
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��8�� ����1:45:10
 */
public class MessageHandlerFactoryImpl implements MessageHandlerFactory {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private NormalMessageHandler<TextInputMessage> textMessageHandler;
	private NormalMessageHandler<ImageInputMessage> imageMessageHandler;
	private NormalMessageHandler<VoiceInputMessage> voiceMessageHandler;
	private NormalMessageHandler<VideoInputMessage> videoMessageHandler;
	private NormalMessageHandler<ShortVideoInputMessage> shortVideoMessageHandler;
	private NormalMessageHandler<LocationInputMessage> locationMessageHandler;
	private NormalMessageHandler<LinkInputMessage> linkMessageHandler;

	private EventMessageHandler<ClickEventMessage> clickEventHandler;
	private EventMessageHandler<ViewEventMessage> viewEventHandler;
	private EventMessageHandler<SubscribeEventMessage> subscribeEventHandler;
	private EventMessageHandler<UnSubscribeEventMessage> unsubscribeEventHandler;
	private EventMessageHandler<QrsceneSubscribeEventMessage> qrsceneSubscribeEventHandler;
	private EventMessageHandler<QrsceneScanEventMessage> qrsceneScanEventHandler;
	private EventMessageHandler<LocationEventMessage> locationEventHandler;
	private EventMessageHandler<ScanCodePushEventMessage> scanCodePushEventHandler;
	private EventMessageHandler<ScanCodeWaitMsgEventMessage> scanCodeWaitMsgEventHandler;
	private EventMessageHandler<PicSysPhotoEventMessage> picSysPhotoEventHandler;
	private EventMessageHandler<PicPhotoOrAlbumEventMessage> picPhotoOrAlbumEventHandler;
	private EventMessageHandler<PicWeixinEventMessage> picWeixinEventHandler;
	private EventMessageHandler<LocationSelectEventMessage> locationSelectEventHandler;

	public NormalMessageHandler<TextInputMessage> getTextMessageHandler() {
		return textMessageHandler;
	}

	public void setTextMessageHandler(NormalMessageHandler<TextInputMessage> textMessageHandler) {
		this.textMessageHandler = textMessageHandler;
	}

	public NormalMessageHandler<ImageInputMessage> getImageMessageHandler() {
		return imageMessageHandler;
	}

	public void setImageMessageHandler(NormalMessageHandler<ImageInputMessage> imageMessageHandler) {
		this.imageMessageHandler = imageMessageHandler;
	}

	public NormalMessageHandler<VoiceInputMessage> getVoiceMessageHandler() {
		return voiceMessageHandler;
	}

	public void setVoiceMessageHandler(NormalMessageHandler<VoiceInputMessage> voiceMessageHandler) {
		this.voiceMessageHandler = voiceMessageHandler;
	}

	public NormalMessageHandler<VideoInputMessage> getVideoMessageHandler() {
		return videoMessageHandler;
	}

	public void setVideoMessageHandler(NormalMessageHandler<VideoInputMessage> videoMessageHandler) {
		this.videoMessageHandler = videoMessageHandler;
	}

	public NormalMessageHandler<ShortVideoInputMessage> getShortVideoMessageHandler() {
		return shortVideoMessageHandler;
	}

	public void setShortVideoMessageHandler(NormalMessageHandler<ShortVideoInputMessage> shortVideoMessageHandler) {
		this.shortVideoMessageHandler = shortVideoMessageHandler;
	}

	public NormalMessageHandler<LocationInputMessage> getLocationMessageHandler() {
		return locationMessageHandler;
	}

	public void setLocationMessageHandler(NormalMessageHandler<LocationInputMessage> locationMessageHandler) {
		this.locationMessageHandler = locationMessageHandler;
	}

	public NormalMessageHandler<LinkInputMessage> getLinkMessageHandler() {
		return linkMessageHandler;
	}

	public void setLinkMessageHandler(NormalMessageHandler<LinkInputMessage> linkMessageHandler) {
		this.linkMessageHandler = linkMessageHandler;
	}

	public EventMessageHandler<ClickEventMessage> getClickEventHandler() {
		return clickEventHandler;
	}

	public void setClickEventHandler(EventMessageHandler<ClickEventMessage> clickEventHandler) {
		this.clickEventHandler = clickEventHandler;
	}

	public EventMessageHandler<ViewEventMessage> getViewEventHandler() {
		return viewEventHandler;
	}

	public void setViewEventHandler(EventMessageHandler<ViewEventMessage> viewEventHandler) {
		this.viewEventHandler = viewEventHandler;
	}

	public EventMessageHandler<SubscribeEventMessage> getSubscribeEventHandler() {
		return subscribeEventHandler;
	}

	public void setSubscribeEventHandler(EventMessageHandler<SubscribeEventMessage> subscribeEventHandler) {
		this.subscribeEventHandler = subscribeEventHandler;
	}

	public EventMessageHandler<UnSubscribeEventMessage> getUnsubscribeEventHandler() {
		return unsubscribeEventHandler;
	}

	public void setUnsubscribeEventHandler(EventMessageHandler<UnSubscribeEventMessage> unsubscribeEventHandler) {
		this.unsubscribeEventHandler = unsubscribeEventHandler;
	}

	public EventMessageHandler<QrsceneSubscribeEventMessage> getQrsceneSubscribeEventHandler() {
		return qrsceneSubscribeEventHandler;
	}

	public void setQrsceneSubscribeEventHandler(
			EventMessageHandler<QrsceneSubscribeEventMessage> qrsceneSubscribeEventHandler) {
		this.qrsceneSubscribeEventHandler = qrsceneSubscribeEventHandler;
	}

	public EventMessageHandler<QrsceneScanEventMessage> getQrsceneScanEventHandler() {
		return qrsceneScanEventHandler;
	}

	public void setQrsceneScanEventHandler(EventMessageHandler<QrsceneScanEventMessage> qrsceneScanEventHandler) {
		this.qrsceneScanEventHandler = qrsceneScanEventHandler;
	}

	public EventMessageHandler<LocationEventMessage> getLocationEventHandler() {
		return locationEventHandler;
	}

	public void setLocationEventHandler(EventMessageHandler<LocationEventMessage> locationEventHandler) {
		this.locationEventHandler = locationEventHandler;
	}

	public EventMessageHandler<ScanCodePushEventMessage> getScanCodePushEventHandler() {
		return scanCodePushEventHandler;
	}

	public void setScanCodePushEventHandler(EventMessageHandler<ScanCodePushEventMessage> scanCodePushEventHandler) {
		this.scanCodePushEventHandler = scanCodePushEventHandler;
	}

	public EventMessageHandler<ScanCodeWaitMsgEventMessage> getScanCodeWaitMsgEventHandler() {
		return scanCodeWaitMsgEventHandler;
	}

	public void setScanCodeWaitMsgEventHandler(
			EventMessageHandler<ScanCodeWaitMsgEventMessage> scanCodeWaitMsgEventHandler) {
		this.scanCodeWaitMsgEventHandler = scanCodeWaitMsgEventHandler;
	}

	public EventMessageHandler<PicSysPhotoEventMessage> getPicSysPhotoEventHandler() {
		return picSysPhotoEventHandler;
	}

	public void setPicSysPhotoEventHandler(EventMessageHandler<PicSysPhotoEventMessage> picSysPhotoEventHandler) {
		this.picSysPhotoEventHandler = picSysPhotoEventHandler;
	}

	public EventMessageHandler<PicPhotoOrAlbumEventMessage> getPicPhotoOrAlbumEventHandler() {
		return picPhotoOrAlbumEventHandler;
	}

	public void setPicPhotoOrAlbumEventHandler(
			EventMessageHandler<PicPhotoOrAlbumEventMessage> picPhotoOrAlbumEventHandler) {
		this.picPhotoOrAlbumEventHandler = picPhotoOrAlbumEventHandler;
	}

	public EventMessageHandler<PicWeixinEventMessage> getPicWeixinEventHandler() {
		return picWeixinEventHandler;
	}

	public void setPicWeixinEventHandler(EventMessageHandler<PicWeixinEventMessage> picWeixinEventHandler) {
		this.picWeixinEventHandler = picWeixinEventHandler;
	}

	public EventMessageHandler<LocationSelectEventMessage> getLocationSelectEventHandler() {
		return locationSelectEventHandler;
	}

	public void setLocationSelectEventHandler(
			EventMessageHandler<LocationSelectEventMessage> locationSelectEventHandler) {
		this.locationSelectEventHandler = locationSelectEventHandler;
	}

	@Override
	public MessageHandler getMessageHandler(InputMessage message) {
		// ȡ����Ϣ����
		String msgType = message.getMsgType();
		// ��ȡ��ͨ��Ϣ��������
		if (msgType.equals(MsgType.Text.toString())) {
			// �����ı���Ϣ
			return new NormalMessageHandlerAdapter<TextInputMessage>(textMessageHandler);
		} else if (msgType.equals(MsgType.Image.toString())) {
			// ����ͼƬ��Ϣ
			return new NormalMessageHandlerAdapter<ImageInputMessage>(imageMessageHandler);
		} else if (msgType.equals(MsgType.Voice.toString())) {
			// ����������Ϣ
			return new NormalMessageHandlerAdapter<VoiceInputMessage>(voiceMessageHandler);
		} else if (msgType.equals(MsgType.Video.toString())) {
			// ������Ƶ��Ϣ
			return new NormalMessageHandlerAdapter<VideoInputMessage>(videoMessageHandler);
		} else if (msgType.equals(MsgType.ShortVideo.toString())) {
			// ����С��Ƶ��Ϣ
			return new NormalMessageHandlerAdapter<ShortVideoInputMessage>(shortVideoMessageHandler);
		} else if (msgType.equals(MsgType.Location.toString())) {
			// �������λ����Ϣ
			return new NormalMessageHandlerAdapter<LocationInputMessage>(locationMessageHandler);
		} else if (msgType.equals(MsgType.Link.toString())) {
			// ����������Ϣ
			return new NormalMessageHandlerAdapter<LinkInputMessage>(linkMessageHandler);
		} else if (msgType.equals(MsgType.Event.toString())) {
			// ��ȡ�¼�����
			String event = message.getEvent();
			// ��ȡ��Ϣ��������
			// �Զ���˵��¼�
			if (event.equals(EventType.Click.toString())) {
				// ����˵���ȡ��Ϣʱ���¼�����
				return new EventMessageHandlerAdapter<ClickEventMessage>(clickEventHandler);
			} else if (event.equals(EventType.View.toString())) {
				// ����˵���ת����ʱ���¼�����
				return new EventMessageHandlerAdapter<ViewEventMessage>(viewEventHandler);
			} else if (event.equals(EventType.Subscribe.toString())) {
				// ��ע�¼�
				return new EventMessageHandlerAdapter<SubscribeEventMessage>(subscribeEventHandler);
			} else if (event.equals(EventType.Unsubscribe.toString())) {
				// ȡ����ע�¼�
				return new EventMessageHandlerAdapter<UnSubscribeEventMessage>(unsubscribeEventHandler);
			} else if (event.equals(EventType.Scan.toString())) {
				// ɨ���������ά���¼�
				// ��ȡ�¼�KEYֵ���ж��Ƿ��ע
				String eventKey = message.getEventKey();
				if (eventKey.startsWith("qrscene_")) {
					// �û�δ��עʱ�����й�ע����¼�����
					return new EventMessageHandlerAdapter<QrsceneSubscribeEventMessage>(qrsceneSubscribeEventHandler);
				} else {
					// �û��ѹ�עʱ���¼�����
					return new EventMessageHandlerAdapter<QrsceneScanEventMessage>(qrsceneScanEventHandler);
				}
			} else if (event.equals(EventType.Location.toString())) {
				// �ϱ�����λ���¼�
				return new EventMessageHandlerAdapter<LocationEventMessage>(locationEventHandler);
			} else if (event.equals(EventType.Scancode_Push.toString())) {
				// ɨ�����¼����¼�����
				return new EventMessageHandlerAdapter<ScanCodePushEventMessage>(scanCodePushEventHandler);
			} else if (event.equals(EventType.Scancode_Waitmsg.toString())) {
				// ɨ�����¼��ҵ�������Ϣ�����С���ʾ����¼�����
				return new EventMessageHandlerAdapter<ScanCodeWaitMsgEventMessage>(scanCodeWaitMsgEventHandler);
			} else if (event.equals(EventType.Pic_Sysphoto.toString())) {
				// ����ϵͳ���շ�ͼ���¼�����
				return new EventMessageHandlerAdapter<PicSysPhotoEventMessage>(picSysPhotoEventHandler);
			} else if (event.equals(EventType.Pic_Photo_OR_Album.toString())) {
				// �������ջ�����ᷢͼ���¼�����
				return new EventMessageHandlerAdapter<PicPhotoOrAlbumEventMessage>(picPhotoOrAlbumEventHandler);
			} else if (event.equals(EventType.Pic_Weixin.toString())) {
				// ����΢����ᷢͼ�����¼�����
				return new EventMessageHandlerAdapter<PicWeixinEventMessage>(picWeixinEventHandler);
			} else if (event.equals(EventType.Location_Select.toString())) {
				// ��������λ��ѡ�������¼�����
				return new EventMessageHandlerAdapter<LocationSelectEventMessage>(locationSelectEventHandler);
			} else {
				return getExtendedEventMessageHandler(event, message);
			}
		} else {
			return getExtendedMessageHandler(msgType, message);
		}
	}

	/**
	 * ������չ���¼���Ϣ�����������ڴ����������͵��¼���Ϣ
	 * 
	 * @param event
	 *            �¼�����
	 * @param message
	 *            ��Ϣ
	 * @return
	 */
	protected MessageHandler getExtendedEventMessageHandler(String event, InputMessage message) {
		return null;
	}

	/**
	 * ������չ����Ϣ�����������ڴ����������͵���Ϣ
	 * 
	 * @param msgTyppe
	 *            ��Ϣ����
	 * @param message
	 *            ��Ϣ
	 * @return
	 */
	protected MessageHandler getExtendedMessageHandler(String msgTyppe, InputMessage message) {
		return null;
	}
}
