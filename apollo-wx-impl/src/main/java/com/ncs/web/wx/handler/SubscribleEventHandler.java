package com.ncs.web.wx.handler;

import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.event.SubscribeEventMessage;
import com.ncs.web.wx.message.output.TextOutputMessage;

/**
 * ��ע��Ϣ������
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��9�� ����6:19:48
 */
public class SubscribleEventHandler extends AbstractEventMessageHandler<SubscribeEventMessage> {

	private String welcomeContent = "лл��ע��";

	public String getWelcomeContent() {
		return welcomeContent;
	}

	public void setWelcomeContent(String message) {
		this.welcomeContent = message;
	}

	@Override
	public OutputMessage handle(SubscribeEventMessage message) {
		TextOutputMessage out = new TextOutputMessage();
		out.setContent(welcomeContent);
		return out;
	}

}
