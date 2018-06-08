package com.ncs.web.wx.message.normal;

import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.MsgType;

/**
 * ͼƬ��Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
public class ImageInputMessage extends NormalMessage {

    //ͼƬ����
    private String PicUrl;
    //ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
    private String MediaId;

    @Override
    public String getMsgType() {
        return MsgType.Image.toString();
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String PicUrl) {
        this.PicUrl = PicUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String MediaId) {
        this.MediaId = MediaId;
    }

}