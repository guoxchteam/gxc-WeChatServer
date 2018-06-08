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
 * 微信消息处理器工厂的缺省实现
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午1:45:10
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
		// 取得消息类型
		String msgType = message.getMsgType();
		// 获取普通消息处理工具类
		if (msgType.equals(MsgType.Text.toString())) {
			// 处理文本消息
			return new NormalMessageHandlerAdapter<TextInputMessage>(textMessageHandler);
		} else if (msgType.equals(MsgType.Image.toString())) {
			// 处理图片消息
			return new NormalMessageHandlerAdapter<ImageInputMessage>(imageMessageHandler);
		} else if (msgType.equals(MsgType.Voice.toString())) {
			// 处理语音消息
			return new NormalMessageHandlerAdapter<VoiceInputMessage>(voiceMessageHandler);
		} else if (msgType.equals(MsgType.Video.toString())) {
			// 处理视频消息
			return new NormalMessageHandlerAdapter<VideoInputMessage>(videoMessageHandler);
		} else if (msgType.equals(MsgType.ShortVideo.toString())) {
			// 处理小视频消息
			return new NormalMessageHandlerAdapter<ShortVideoInputMessage>(shortVideoMessageHandler);
		} else if (msgType.equals(MsgType.Location.toString())) {
			// 处理地理位置消息
			return new NormalMessageHandlerAdapter<LocationInputMessage>(locationMessageHandler);
		} else if (msgType.equals(MsgType.Link.toString())) {
			// 处理链接消息
			return new NormalMessageHandlerAdapter<LinkInputMessage>(linkMessageHandler);
		} else if (msgType.equals(MsgType.Event.toString())) {
			// 获取事件类型
			String event = message.getEvent();
			// 获取消息处理工具类
			// 自定义菜单事件
			if (event.equals(EventType.Click.toString())) {
				// 点击菜单拉取消息时的事件推送
				return new EventMessageHandlerAdapter<ClickEventMessage>(clickEventHandler);
			} else if (event.equals(EventType.View.toString())) {
				// 点击菜单跳转链接时的事件推送
				return new EventMessageHandlerAdapter<ViewEventMessage>(viewEventHandler);
			} else if (event.equals(EventType.Subscribe.toString())) {
				// 关注事件
				return new EventMessageHandlerAdapter<SubscribeEventMessage>(subscribeEventHandler);
			} else if (event.equals(EventType.Unsubscribe.toString())) {
				// 取消关注事件
				return new EventMessageHandlerAdapter<UnSubscribeEventMessage>(unsubscribeEventHandler);
			} else if (event.equals(EventType.Scan.toString())) {
				// 扫描带参数二维码事件
				// 获取事件KEY值，判断是否关注
				String eventKey = message.getEventKey();
				if (eventKey.startsWith("qrscene_")) {
					// 用户未关注时，进行关注后的事件推送
					return new EventMessageHandlerAdapter<QrsceneSubscribeEventMessage>(qrsceneSubscribeEventHandler);
				} else {
					// 用户已关注时的事件推送
					return new EventMessageHandlerAdapter<QrsceneScanEventMessage>(qrsceneScanEventHandler);
				}
			} else if (event.equals(EventType.Location.toString())) {
				// 上报地理位置事件
				return new EventMessageHandlerAdapter<LocationEventMessage>(locationEventHandler);
			} else if (event.equals(EventType.Scancode_Push.toString())) {
				// 扫码推事件的事件推送
				return new EventMessageHandlerAdapter<ScanCodePushEventMessage>(scanCodePushEventHandler);
			} else if (event.equals(EventType.Scancode_Waitmsg.toString())) {
				// 扫码推事件且弹出“消息接收中”提示框的事件推送
				return new EventMessageHandlerAdapter<ScanCodeWaitMsgEventMessage>(scanCodeWaitMsgEventHandler);
			} else if (event.equals(EventType.Pic_Sysphoto.toString())) {
				// 弹出系统拍照发图的事件推送
				return new EventMessageHandlerAdapter<PicSysPhotoEventMessage>(picSysPhotoEventHandler);
			} else if (event.equals(EventType.Pic_Photo_OR_Album.toString())) {
				// 弹出拍照或者相册发图的事件推送
				return new EventMessageHandlerAdapter<PicPhotoOrAlbumEventMessage>(picPhotoOrAlbumEventHandler);
			} else if (event.equals(EventType.Pic_Weixin.toString())) {
				// 弹出微信相册发图器的事件推送
				return new EventMessageHandlerAdapter<PicWeixinEventMessage>(picWeixinEventHandler);
			} else if (event.equals(EventType.Location_Select.toString())) {
				// 弹出地理位置选择器的事件推送
				return new EventMessageHandlerAdapter<LocationSelectEventMessage>(locationSelectEventHandler);
			} else {
				return getExtendedEventMessageHandler(event, message);
			}
		} else {
			return getExtendedMessageHandler(msgType, message);
		}
	}

	/**
	 * 返回扩展的事件消息处理器，用于处理其他类型的事件消息
	 * 
	 * @param event
	 *            事件类型
	 * @param message
	 *            消息
	 * @return
	 */
	protected MessageHandler getExtendedEventMessageHandler(String event, InputMessage message) {
		return null;
	}

	/**
	 * 返回扩展的消息处理器，用于处理其他类型的消息
	 * 
	 * @param msgTyppe
	 *            消息类型
	 * @param message
	 *            消息
	 * @return
	 */
	protected MessageHandler getExtendedMessageHandler(String msgTyppe, InputMessage message) {
		return null;
	}
}
