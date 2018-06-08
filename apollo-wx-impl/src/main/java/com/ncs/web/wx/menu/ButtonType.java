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
package com.ncs.web.wx.menu;

/**
 * �Զ���˵�����
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public enum ButtonType {

    /**
     * ������¼�
     */
    Click("click"),
    /**
     * ��תURL
     */
    View("view"),
    /**
     * ɨ�����¼�
     */
    Scancode_Push("scancode_push"),
    /**
     * ɨ�����¼��ҵ�������Ϣ�����С���ʾ��
     */
    Scancode_Waitmsg("scancode_waitmsg"),
    /**
     * ����ϵͳ���շ�ͼ
     */
    Pic_SysPhoto("pic_sysphoto"),
    /**
     * �������ջ�����ᷢͼ
     */
    Pic_Photo_OR_Album("pic_photo_or_album"),
    /**
     * ����΢����ᷢͼ��
     */
    Pic_Weixin("pic_weixin"),
    /**
     * ��������λ��ѡ����
     */
    Location_Select("location_select"),
    /**
     * �·���Ϣ�����ı���Ϣ��
     */
    Media_Id("media_id"),
    /**
     * ��תͼ����ϢURL
     */
    View_Limited("view_limited");
    
    private String value = "";

    ButtonType(String value) {
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
