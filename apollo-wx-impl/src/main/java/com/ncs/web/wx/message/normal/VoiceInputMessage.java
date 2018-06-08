package com.ncs.web.wx.message.normal;

import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.MsgType;

/**
 * ������Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
public class VoiceInputMessage extends NormalMessage {

    //������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
    private String MediaId;
    //������ʽ����amr��speex��
    private String Format;
    //����ʶ������ʹ��UTF8����
    private String Recognition;

    @Override
    public String getMsgType() {
        return MsgType.Voice.toString();
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String MediaId) {
        this.MediaId = MediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String Recognition) {
        this.Recognition = Recognition;
    }

}