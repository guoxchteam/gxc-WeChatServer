package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.SendLocationInfo;

/**
 * �Զ���˵��¼�
 *
 * ��������λ��ѡ�������¼�����
 *
 * @author qsyang
 * @version 1.0
 */
public class LocationSelectEventMessage extends EventMessage {

    //�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
    private String EventKey;
    //���͵�λ����Ϣ
    private SendLocationInfo SendLocationInfo;

    @Override
    public String getEvent() {
        return EventType.Pic_Sysphoto.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo SendLocationInfo) {
        this.SendLocationInfo = SendLocationInfo;
    }

}