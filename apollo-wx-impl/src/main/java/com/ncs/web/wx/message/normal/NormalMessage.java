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
package com.ncs.web.wx.message.normal;

import javax.xml.bind.annotation.XmlElement;

/**
 * ��ͨ��Ϣ
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public abstract class NormalMessage {

    /**
     * ������΢�ź�
     */
    private String ToUserName;
    /**
     * ���ͷ��ʺţ�һ��OpenID��
     */
    private String FromUserName;
    /**
     * ��Ϣ����ʱ�� �����ͣ�
     */
    private Long CreateTime;
    /**
     * ��Ϣid��64λ����
     */
    private Long MsgId;

    /**
     * ��ȡ ��Ϣ����
     *
     * @return ��Ϣ����
     */
    public abstract String getMsgType();

    public String getToUserName() {
        return ToUserName;
    }

    @XmlElement(name = "ToUserName")
    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    @XmlElement(name = "FromUserName")
    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    @XmlElement(name = "CreateTime")
    public void setCreateTime(Long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public Long getMsgId() {
        return MsgId;
    }

    @XmlElement(name = "MsgId")
    public void setMsgId(Long MsgId) {
        this.MsgId = MsgId;
    }
}