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
package com.ncs.web.wx.message;

/**
 * ΢�ŷ��ͱ�����Ӧ��Ϣ�ĳ�����
 *
 * <p>
 * Ӧ�ó�����Ҫ����һ�����࣬��ʵ�־��巽��</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public abstract class OutputMessage implements java.io.Serializable {

    /**
     * ���շ��ʺţ��յ���OpenID��
     */
    private String ToUserName;
    /**
     * ������΢�ź�
     */
    private String FromUserName;
    /**
     * ��Ϣ����ʱ�� �����ͣ�
     */
    private Long CreateTime;

    /**
     * ��ȡ ���շ��ʺţ��յ���OpenID��
     *
     * @return ���շ��ʺţ��յ���OpenID��
     */
    public String getToUserName() {
        return ToUserName;
    }

    /**
     * ���� ���շ��ʺţ��յ���OpenID��
     *
     * @return ���շ��ʺţ��յ���OpenID��
     */
    public String getFromUserName() {
        return FromUserName;
    }

    /**
     * ��ȡ ��Ϣ����ʱ�� �����ͣ�
     *
     * @return ��Ϣ����ʱ�� �����ͣ�
     */
    public Long getCreateTime() {
        return CreateTime;
    }

    /**
     * ��ȡ ��Ϣ����
     *
     * @return ��Ϣ����
     */
    public abstract String getMsgType();

    /**
     * ������ת��Ϊxml�ַ���
     *
     * @return ����xml�ַ���
     */
    public abstract String toXML();

    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }

    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    public void setCreateTime(Long CreateTime) {
        this.CreateTime = CreateTime;
    }
}