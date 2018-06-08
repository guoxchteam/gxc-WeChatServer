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

import com.ncs.web.wx.message.Articles;
import com.ncs.web.wx.message.OutputMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ʵ����<tt>OutputMessage</tt>�������ظ�ͼ����Ϣ
 *
 * <p>
 * �ṩ�˻�ȡ����ͼ����Ϣ��Ϣ<code>getArticles()</code>����Ҫ����.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class NewsOutputMessage extends OutputMessage {

    /**
     * ��Ϣ����:ͼ����Ϣ
     */
    private final String MsgType = "news";
    /**
     * ͼ����Ϣ����������Ϊ10������
     */
    private Integer ArticleCount;
    /**
     * ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10���򽫻�����Ӧ
     */
    private List<Articles> Articles;

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
     * ��ȡ ͼ����Ϣ����
     *
     * @return ͼ����Ϣ����
     */
    public Integer getArticleCount() {
        return ArticleCount;
    }

    /**
     * ��ȡ ����ͼ����Ϣ��Ϣ
     *
     * @return ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10����ֻ��ȡǰ10��
     */
    public List<Articles> getArticles() {
        return Articles;
    }

    /**
     * ���� ����ͼ����Ϣ��Ϣ
     *
     * @param articles ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10����ֻ��ȡǰ10��
     */
    public void setArticles(List<Articles> articles) {
        if (articles != null) {
            if (articles.size() > 10) {
                articles = new ArrayList<Articles>(articles.subList(0, 10));
            }
            ArticleCount = articles.size();
        }
        Articles = articles;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<ArticleCount>").append(this.ArticleCount).append("</ArticleCount>");
        sb.append("<Articles>");
        for (Articles article : Articles) {
            sb.append("<item>");
            sb.append("<Title><![CDATA[").append(article.getTitle()).append("]]></Title>");
            sb.append("<Description><![CDATA[").append(article.getDescription()).append("]]></Description>");
            sb.append("<PicUrl><![CDATA[").append(article.getPicUrl()).append("]]></PicUrl>");
            sb.append("<Url><![CDATA[").append(article.getUrl()).append("]]></Url>");
            sb.append("</item>");
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }
}