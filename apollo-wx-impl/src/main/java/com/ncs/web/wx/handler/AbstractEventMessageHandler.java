package com.ncs.web.wx.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.InputMessage;
import com.ncs.web.wx.message.event.EventMessage;
import com.ncs.web.wx.service.EventMessageHandler;

/**
 * 事件消息处理器的基础类
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月8日 下午3:44:41
 */
public abstract class AbstractEventMessageHandler<M extends EventMessage> implements EventMessageHandler<M> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	@Override
	public M getEventMessage(InputMessage message) {
		if (message == null) {
			return null;
		} // 获取事件类型
		String event = message.getEvent();

		// 自定义菜单事件
		if (event.equals(EventType.Click.toString())) {
			// 点击菜单拉取消息时的事件推送
			return (M) message.toClickEventMessage();
		} else if (event.equals(EventType.View.toString())) {
			// 点击菜单跳转链接时的事件推送
			return (M) message.toViewEventMessage();
		} else if (event.equals(EventType.Subscribe.toString())) {
			// 关注事件
			return (M) message.toSubscribeEventMessage();
		} else if (event.equals(EventType.Unsubscribe.toString())) {
			// 取消关注事件
			return (M) message.toUnSubscribeEventMessage();
		} else if (event.equals(EventType.Scan.toString())) {
			// 扫描带参数二维码事件
			// 获取事件KEY值，判断是否关注
			String eventKey = message.getEventKey();
			if (eventKey.startsWith("qrscene_")) {
				// 用户未关注时，进行关注后的事件推送
				return (M) message.toQrsceneSubscribeEventMessage();
			} else {
				// 用户已关注时的事件推送
				return (M) message.toQrsceneScanEventMessage();
			}
		} else if (event.equals(EventType.Location.toString())) {
			// 上报地理位置事件
			return (M) message.toLocationEventMessage();
		} else if (event.equals(EventType.Scancode_Push.toString())) {
			// 扫码推事件的事件推送
			return (M) message.toScanCodePushEventMessage();
		} else if (event.equals(EventType.Scancode_Waitmsg.toString())) {
			// 扫码推事件且弹出“消息接收中”提示框的事件推送
			return (M) message.toScanCodeWaitMsgEventMessage();
		} else if (event.equals(EventType.Pic_Sysphoto.toString())) {
			// 弹出系统拍照发图的事件推送
			return (M) message.toPicSysPhotoEventMessage();
		} else if (event.equals(EventType.Pic_Photo_OR_Album.toString())) {
			// 弹出拍照或者相册发图的事件推送
			return (M) message.toPicPhotoOrAlbumEventMessage();
		} else if (event.equals(EventType.Pic_Weixin.toString())) {
			// 弹出微信相册发图器的事件推送
			return (M) message.toPicWeixinEventMessage();
		} else if (event.equals(EventType.Location_Select.toString())) {
			// 弹出地理位置选择器的事件推送
			return (M) message.toLocationSelectEventMessage();
		} else {
			return getExtendedEventMessage(event, message);
		}
	}

	/**
	 * 转换扩展类型的消息
	 * 
	 * @param event
	 * @param message
	 * @return
	 */
	protected M getExtendedEventMessage(String event, InputMessage message) {
		return null;
	}

}
