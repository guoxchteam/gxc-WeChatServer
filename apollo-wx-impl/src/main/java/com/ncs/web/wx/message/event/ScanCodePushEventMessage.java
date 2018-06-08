package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;
import com.ncs.web.wx.message.ScanCodeInfo;

/**
 * �Զ���˵��¼�
 *
 * ɨ�����¼����¼�����
 *
 * @author qsyang
 * @version 1.0
 */
public class ScanCodePushEventMessage extends EventMessage {

    //�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
    private String EventKey;
    //ɨ����Ϣ
    private ScanCodeInfo ScanCodeInfo;

    @Override
    public String getEvent() {
        return EventType.Scancode_Push.toString();
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