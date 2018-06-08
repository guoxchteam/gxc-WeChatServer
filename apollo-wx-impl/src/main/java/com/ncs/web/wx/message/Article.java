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
 *
 * @author weixin4j<weixin4j@ansitech.com>
 * @version 1.0
 */
public class Article {

    private String thumb_media_id;  //ͼ����Ϣ����ͼ��media_id�������ڻ���֧��-�ϴ���ý���ļ��ӿ��л��
    private String author;  //ͼ����Ϣ������
    private String title;   //ͼ����Ϣ�ı���
    private String content_source_url;  //��ͼ����Ϣҳ�������Ķ�ԭ�ġ����ҳ��
    private String content; //ͼ����Ϣҳ������ݣ�֧��HTML��ǩ
    private String digest;  //ͼ����Ϣ������
    private int show_cover_pic;//�Ƿ���ʾ���棬1Ϊ��ʾ��0Ϊ����ʾ

    /**
     * @return the thumb_media_id
     */
    public String getThumb_media_id() {
        return thumb_media_id;
    }

    /**
     * @param thumb_media_id the thumb_media_id to set
     */
    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content_source_url
     */
    public String getContent_source_url() {
        return content_source_url;
    }

    /**
     * @param content_source_url the content_source_url to set
     */
    public void setContent_source_url(String content_source_url) {
        this.content_source_url = content_source_url;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * @param digest the digest to set
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * @return the show_cover_pic
     */
    public int getShow_cover_pic() {
        return show_cover_pic;
    }

    /**
     * @param show_cover_pic the show_cover_pic to set
     */
    public void setShow_cover_pic(int show_cover_pic) {
        this.show_cover_pic = show_cover_pic;
    }
}