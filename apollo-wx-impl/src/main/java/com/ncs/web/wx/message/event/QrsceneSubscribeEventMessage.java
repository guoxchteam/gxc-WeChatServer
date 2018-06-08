package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;

/**
 * ɨ���������ά���¼�
 *
 * �û�δ��ע
 *
 * @author qsyang
 * @version 1.0
 */
public class QrsceneSubscribeEventMessage extends EventMessage {

    //�¼�KEYֵ��qrscene_Ϊǰ׺������Ϊ��ά��Ĳ���ֵ
    private String EventKey;
    //��ά���ticket����������ȡ��ά��ͼƬ
    private String Ticket;

    @Override
    public String getEvent() {
        return EventType.Subscribe.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String Ticket) {
        this.Ticket = Ticket;
    }

}