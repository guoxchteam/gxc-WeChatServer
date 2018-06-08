package com.ncs.web.wx.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ���͵�λ����Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
@XmlRootElement(name = "SendLocationInfo")
public class SendLocationInfo {

    //X������Ϣ
    private double Location_X;
    //Y������Ϣ
    private double Location_Y;
    //���ȣ������Ϊ���Ȼ��߱����ߡ�Խ��ϸ�Ļ� scaleԽ��
    private int Scale;
    //����λ�õ��ַ�����Ϣ
    private String Label;
    //����ȦPOI�����֣�����Ϊ��
    private String Poiname;

    public double getLocation_X() {
        return Location_X;
    }

    @XmlElement(name = "Location_X")
    public void setLocation_X(double Location_X) {
        this.Location_X = Location_X;
    }

    public double getLocation_Y() {
        return Location_Y;
    }

    @XmlElement(name = "Location_Y")
    public void setLocation_Y(double Location_Y) {
        this.Location_Y = Location_Y;
    }

    public int getScale() {
        return Scale;
    }

    @XmlElement(name = "Scale")
    public void setScale(int Scale) {
        this.Scale = Scale;
    }

    public String getLabel() {
        return Label;
    }

    @XmlElement(name = "Label")
    public void setLabel(String Label) {
        this.Label = Label;
    }

    public String getPoiname() {
        return Poiname;
    }

    @XmlElement(name = "Poiname")
    public void setPoiname(String Poiname) {
        this.Poiname = Poiname;
    }

}