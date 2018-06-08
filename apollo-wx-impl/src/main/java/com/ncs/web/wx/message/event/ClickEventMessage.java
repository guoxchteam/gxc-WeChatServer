package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;

/**
 * �Զ���˵��¼�
 * 
 * ����˵���ȡ��Ϣʱ���¼�����
 *
 * @author qsyang
 * @version 1.0
 */
public class ClickEventMessage extends EventMessage {

    //�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
    private String EventKey;

    @Override
    public String getEvent() {
        return EventType.Click.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

}