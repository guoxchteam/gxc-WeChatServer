package com.ncs.web.wx.message.normal;

import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.MsgType;

/**
 * ����λ����Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
public class LocationInputMessage extends NormalMessage {

    //����λ��ά��
    private String Location_X;
    //����λ�þ���
    private String Location_Y;
    //��ͼ���Ŵ�С
    private Long Scale;
    //����λ����Ϣ
    private String Label;

    @Override
    public String getMsgType() {
        return MsgType.Location.toString();
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String Location_X) {
        this.Location_X = Location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String Location_Y) {
        this.Location_Y = Location_Y;
    }

    public Long getScale() {
        return Scale;
    }

    public void setScale(Long Scale) {
        this.Scale = Scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }

}