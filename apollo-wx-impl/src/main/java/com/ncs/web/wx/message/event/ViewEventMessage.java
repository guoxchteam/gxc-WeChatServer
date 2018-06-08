package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;

/**
 * �Զ���˵��¼�
 *
 * ����˵���ת����ʱ���¼�����
 *
 * @author qsyang
 * @version 1.0
 */
public class ViewEventMessage extends EventMessage {

    //�¼�KEYֵ�����õ���תURL
    private String EventKey;
    private String MenuId;

    @Override
    public String getEvent() {
        return EventType.View.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }
    
    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String MenuId) {
        this.MenuId = MenuId;
    }

}