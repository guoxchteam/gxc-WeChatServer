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

import com.ncs.web.wx.message.OutputMessage;

/**
 * �����ʵ����<tt>OutputMessage</tt>�������ظ��ı���Ϣ
 *
 * <p>
 * �ṩ�˻�ȡ�ı�����<code>getContent()</code>����Ҫ����.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class TextOutputMessage extends OutputMessage {

    /**
     * ��Ϣ����:�ı���Ϣ
     */
    private final String MsgType = "text";
    /**
     * �ı���Ϣ
     */
    private String Content;

    /**
     * ����һ���µ� Output Message.����MsgType��ֵΪtext.
     */
    public TextOutputMessage() {
    }

    /**
     * ����һ���Զ����ı�����content��Output Message.
     *
     * @param content �ı�����
     */
    public TextOutputMessage(String content) {
        Content = content;
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
     * ��ȡ �ı���Ϣ
     *
     * @return �ı���Ϣ
     */
    public String getContent() {
        return Content;
    }

    /**
     * ���� �ı���Ϣ
     *
     * @param content �ı���Ϣ
     */
    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Content><![CDATA[").append(this.getContent()).append("]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }
}