package com.ncs.web.wx.message.normal;

import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.MsgType;

/**
 * �ı���Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
public class TextInputMessage extends NormalMessage {

    //�ı���Ϣ����
    private String Content;

    public TextInputMessage(String Content) {
        this.Content = Content;
    }

    @Override
    public String getMsgType() {
        return MsgType.Text.toString();
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
}