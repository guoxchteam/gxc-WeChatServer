package com.ncs.web.wx.message.event;

import com.ncs.web.wx.message.EventType;

/**
 * �ϱ�����λ���¼�
 *
 * @author qsyang
 * @version 1.0
 */
public class LocationEventMessage extends EventMessage {

    //����λ��γ��
    private String Latitude;
    //����λ�þ���
    private String Longitude;
    //����λ�þ���
    private String Precision;

    @Override
    public String getEvent() {
        return EventType.Location_Select.toString();
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String Precision) {
        this.Precision = Precision;
    }

}