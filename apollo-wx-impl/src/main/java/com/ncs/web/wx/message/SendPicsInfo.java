package com.ncs.web.wx.message;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ���͵�ͼƬ��Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
@XmlRootElement(name = "SendPicsInfo")
public class SendPicsInfo {

    //���͵�ͼƬ����
    private int Count;
    //ͼƬ�б�
    private List<PicList> PicList;

    public int getCount() {
        return Count;
    }

    @XmlElement(name = "Count")
    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<PicList> getPicList() {
        return PicList;
    }

    @XmlElementWrapper(name = "PicList")
    @XmlElement(name = "item")
    public void setPicList(List<PicList> PicList) {
        this.PicList = PicList;
    }
}