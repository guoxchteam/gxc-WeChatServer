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
 * �ظ���Ƶ��Ϣ�е���Ƶ����
 *
 * <p>�ṩ�˻�ȡ��ƵId<code>getMediaId()</code>����Ҫ����.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class Video implements java.io.Serializable {

    private String MediaId;     //ͨ���ϴ���ý���ļ����õ���id
    private String Title;       //��Ƶ��Ϣ�ı���
    private String Description; //��Ƶ��Ϣ������

    /**
     * ��ȡ ͨ���ϴ���ý���ļ����õ���id
     *
     * @return ͨ���ϴ���ý���ļ����õ���id
     */
    public String getMediaId() {
        return MediaId;
    }

    /**
     * ���� ͨ���ϴ���ý���ļ����õ���id
     *
     * @param image ͨ���ϴ���ý���ļ����õ���id
     */
    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
}