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
 * ʵ���������������<tt>NewsOutputMessage</tt>�е���Ŀ
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class Articles {

    /**
     * ͼ����Ϣ����
     */
    private String Title;
    /**
     * ͼ����Ϣ����
     */
    private String Description;
    /**
     * ���ͱ�����Ӧʱ���õ�ͼƬurl
     * ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ360*200��Сͼ200*200
     */
    private String PicUrl;
    /**
     * ���Ϳͷ���Ϣʱ���õ�ͼƬURL
     */
    private String picurl;
    /**
     * ���ͼ����Ϣ��ת����
     */
    private String Url;

    /**
     * ��ȡ ͼ����Ϣ�ı���
     *
     * @return ͼ����Ϣ�ı���
     */
    public String getTitle() {
        return Title;
    }

    /**
     * ���� ͼ����Ϣ�ı���
     *
     * @param Title ͼ����Ϣ�ı���
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * ��ȡ ͼ����Ϣ������
     *
     * @return ͼ����Ϣ������
     */
    public String getDescription() {
        return Description;
    }

    /**
     * ���� ͼ����Ϣ������
     *
     * @param Description ͼ����Ϣ������
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * ��ȡ ͼƬ����
     *
     * @return ͼƬ����
     */
    public String getPicUrl() {
        return PicUrl;
    }

    /**
     * ���� ͼƬ����
     *
     * @param PicUrl ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ360*200��Сͼ200*200
     */
    public void setPicUrl(String PicUrl) {
        this.PicUrl = PicUrl;
    }

    /**
     * ��ȡ ���ͼ����Ϣ��ת����
     *
     * @return ���ͼ����Ϣ��ת����
     */
    public String getUrl() {
        return Url;
    }

    /**
     * ���� ���ͼ����Ϣ��ת����
     *
     * @param Url ���ͼ����Ϣ��ת����
     */
    public void setUrl(String Url) {
        this.Url = Url;
    }

    /**
     * @return the picurl
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * @param picurl the picurl to set
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}