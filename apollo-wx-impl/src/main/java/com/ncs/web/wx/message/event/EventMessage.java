package com.ncs.web.wx.message.event;

/**
 * �¼���Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
public abstract class EventMessage {

    //������΢�ź�
    private String ToUserName;
    //���ͷ��ʺţ�һ��OpenID��
    private String FromUserName;
    //��Ϣ����ʱ�� �����ͣ�
    private Long CreateTime;
    //��Ϣ���ͣ�event
    private String MsgType = "event";

    /**
     * ��ȡ �¼�����
     *
     * @return �¼�����
     */
    public abstract String getEvent();

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getMsgType() {
        return MsgType;
    }
}