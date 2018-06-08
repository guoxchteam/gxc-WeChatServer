package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;

/**
 * ¹Ø×¢ÊÂ¼þ
 *
 * @author qsyang
 * @version 1.0
 */
public class SubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Subscribe.toString();
    }

}