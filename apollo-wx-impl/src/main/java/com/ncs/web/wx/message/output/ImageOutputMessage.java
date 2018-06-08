/*
 * ΢�Ź���ƽ̨(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ncs.web.wx.message.output;

import com.ncs.web.wx.message.Image;
import com.ncs.web.wx.message.OutputMessage;

/**
 * �����ʵ����<tt>OutputMessage</tt>�������ظ�ͼƬ��Ϣ
 *
 * <p>
 * �ṩ�˻�ȡͼƬId<code>getMediaId()</code>����Ҫ����.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class ImageOutputMessage extends OutputMessage {

    /**
     * ��Ϣ����:ͼƬ��Ϣ
     */
    private final String MsgType = "image";
    /**
     * ͨ���ϴ���ý���ļ����õ���id
     */
    private Image Image;

    /**
     * ����һ��ͼƬ Output Message.
     *
     * ����MsgType��ֵΪimage.
     */
    public ImageOutputMessage() {
    }

    /**
     * ����һ��ͼƬ ��Output Message.
     *
     * ����MsgType��ֵΪimage.
     *
     * @param image ͼƬ
     */
    public ImageOutputMessage(Image image) {
        this.Image = image;
    }

    /**
     * ��ȡ ��Ϣ����
     *
     * @return ��Ϣ����
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    /**
     * ��ȡ ͨ���ϴ���ý���ļ����õ���id
     *
     * @return ͨ���ϴ���ý���ļ����õ���id��װ��image����
     */
    public Image getImage() {
        return this.Image;
    }

    /**
     * ���� ͨ���ϴ���ý���ļ����õ���id
     *
     * @param image ͨ���ϴ���ý���ļ����õ���id��װ��image����
     */
    public void setImage(Image image) {
        this.Image = image;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Image>");
        sb.append("<MediaId><![CDATA[").append(this.getImage().getMediaId()).append("]]></MediaId>");
        sb.append("</Image>");
        sb.append("</xml>");
        return sb.toString();
    }
}