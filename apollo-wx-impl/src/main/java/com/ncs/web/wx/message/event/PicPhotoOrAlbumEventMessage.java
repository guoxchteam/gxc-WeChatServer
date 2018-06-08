package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.SendPicsInfo;

/**
 * �Զ���˵��¼�
 *
 * �������ջ�����ᷢͼ���¼�����
 *
 * @author qsyang
 * @version 1.0
 */
public class PicPhotoOrAlbumEventMessage extends EventMessage {

    //�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
    private String EventKey;
    //���͵�ͼƬ��Ϣ
    private SendPicsInfo SendPicsInfo;

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

    public SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo SendPicsInfo) {
        this.SendPicsInfo = SendPicsInfo;
    }

}