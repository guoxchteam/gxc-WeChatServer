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
 * �¼�����
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public enum EventType {

    /**
     * ����
     */
    Subscribe("subscribe"),
    /**
     * ȡ������
     */
    Unsubscribe("unsubscribe"),
    /**
     * �ѹ�ע�û�ɨ���������ά��
     */
    Scan("scan"),
    /**
     * �ϱ�����λ��
     */
    Location("location"),
    /**
     * ����Զ���˵�
     */
    Click("click"),
    /**
     * �鿴�˵�
     */
    View("view"),
    /**
     * ɨ�����¼�
     */
    Scancode_Push("scancode_push"),
    /**
     * ɨ�����¼�
     */
    Scancode_Waitmsg("scancode_waitmsg"),
    /**
     * ����ϵͳ���շ�ͼ���¼�
     */
    Pic_Sysphoto("pic_sysphoto"),
    /**
     * �������ջ�����ᷢͼ���¼�
     */
    Pic_Photo_OR_Album("pic_photo_or_album"),
    /**
     * ����΢����ᷢͼ�����¼�
     */
    Pic_Weixin("pic_weixin"),
    /**
     * ��������λ��ѡ�������¼�
     */
    Location_Select("location_select");

    private String value = "";

    EventType(String value) {
        this.value = value;
    }

    /**
     * @return the msgType
     */
    @Override
    public String toString() {
        return value;
    }
}