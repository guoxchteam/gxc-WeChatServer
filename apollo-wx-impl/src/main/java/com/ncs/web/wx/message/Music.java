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
 * �ظ�������Ϣ�е����ֶ���
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class Music implements java.io.Serializable {

    private String Title;           //���ֱ���
    private String Description;     //��������
    private String MusicUrl;        //��������
    private String HQMusicUrl;      //�������������ӣ�WIFI��������ʹ�ø����Ӳ�������
    private String ThumbMediaId;    //����ͼ��ý��id��ͨ���ϴ���ý���ļ����õ���id

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

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String MusicUrl) {
        this.MusicUrl = MusicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String ThumbMediaId) {
        this.ThumbMediaId = ThumbMediaId;
    }
}