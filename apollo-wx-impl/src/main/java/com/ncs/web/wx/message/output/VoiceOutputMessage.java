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

import com.ncs.web.wx.message.Voice;
import com.ncs.web.wx.message.OutputMessage;

/**
 * �����ʵ����<tt>OutputMessage</tt>�������ظ�������Ϣ
 *
 * <p>�ṩ�˻�ȡ����Id<code>getVoice()</code>����Ҫ����.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class VoiceOutputMessage extends OutputMessage {

    /**
     * ��Ϣ����:������Ϣ
     */
    private final String MsgType = "voice";
    /**
     * ͨ���ϴ���ý���ļ����õ���id��װ��Voice����
     */
    private Voice Voice;

    /**
     * ����һ���µ� Output Message.����MsgType��ֵΪvoice.
     */
    public VoiceOutputMessage() {
    }

    /**
     * ����һ���Զ�������Id mediaId��Output Message.
     *
     * @param voice ������ԴId
     */
    public VoiceOutputMessage(Voice voice) {
        Voice = voice;
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
     * ��ȡ ͨ���ϴ���ý���ļ����õ���id��װ��Voice����
     *
     * @return ͨ���ϴ���ý���ļ����õ���id��װ��Voice����
     */
    public Voice getVoice() {
        return Voice;
    }

    /**
     * ���� ͨ���ϴ���ý���ļ����õ���id��װ��Voice����
     *
     * @param voice ͨ���ϴ���ý���ļ����õ���id��װ��Voice����
     */
    public void setVoice(Voice voice) {
        Voice = voice;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Voice>");
        sb.append("<MediaId><![CDATA[").append(this.getVoice().getMediaId()).append("]]></MediaId>");
        sb.append("</Voice>");
        sb.append("</xml>");
        return sb.toString();
    }
}