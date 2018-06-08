package com.ncs.web.wx.message.normal;

import com.ncs.web.wx.message.normal.NormalMessage;
import com.ncs.web.wx.message.MsgType;

/**
 * ������Ϣ
 *
 * @author qsyang
 * @version 1.0
 */
public class LinkInputMessage extends NormalMessage {

    //��Ϣ����
    private String Title;
    //��Ϣ����
    private String Description;
    //��Ϣ����
    private String Url;

    @Override
    public String getMsgType() {
        return MsgType.Link.toString();
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}