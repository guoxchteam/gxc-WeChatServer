package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.ScanCodeInfo;

/**
 * �Զ���˵��¼�
 *
 * ɨ�����¼��ҵ�������Ϣ�����С���ʾ����¼�����
 *
 * @author qsyang
 * @version 1.0
 */
public class ScanCodeWaitMsgEventMessage extends EventMessage {

    //�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
    private String EventKey;
    //ɨ����Ϣ
    private ScanCodeInfo ScanCodeInfo;

    @Override
    public String getEvent() {
        return EventType.Scancode_Waitmsg.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo ScanCodeInfo) {
        this.ScanCodeInfo = ScanCodeInfo;
    }

}