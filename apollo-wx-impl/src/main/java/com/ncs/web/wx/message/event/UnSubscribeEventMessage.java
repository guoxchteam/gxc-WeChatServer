package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;

/**
 * ȡ����ע�¼�
 *
 * @author qsyang
 * @version 1.0
 */
public class UnSubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Unsubscribe.toString();
    }

}