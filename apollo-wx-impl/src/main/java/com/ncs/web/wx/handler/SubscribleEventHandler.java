package com.ncs.web.wx.handler;

import com.ncs.web.wx.message.OutputMessage;
import com.ncs.web.wx.message.event.SubscribeEventMessage;
import com.ncs.web.wx.message.output.TextOutputMessage;

/**
 * 关注消息处理器
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月9日 下午6:19:48
 */
public class SubscribleEventHandler extends AbstractEventMessageHandler<SubscribeEventMessage> {

	private String welcomeContent = "谢谢关注！";

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
