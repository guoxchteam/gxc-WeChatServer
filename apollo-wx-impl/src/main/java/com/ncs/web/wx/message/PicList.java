package com.ncs.web.wx.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ͼƬ
 *
 * @author qsyang
 * @version 1.0
 */
@XmlRootElement(name = "item")
public class PicList {

    //ͼƬ��MD5ֵ������������Ҫ����������֤���յ�ͼƬ
    private String PicMd5Sum;

    public String getPicMd5Sum() {
        return PicMd5Sum;
    }

    @XmlElement(name = "PicMd5Sum")
    public void setPicMd5Sum(String PicMd5Sum) {
        this.PicMd5Sum = PicMd5Sum;
    }
}