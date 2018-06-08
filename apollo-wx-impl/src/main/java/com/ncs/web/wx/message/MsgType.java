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
 * ��Ϣ����
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public enum MsgType {

    /**
     * 1 �ı���Ϣ
     */
    Text("text"),
    /**
     * 2 ͼƬ��Ϣ
     */
    Image("image"),
    /**
     * 3 ������Ϣ
     */
    Voice("voice"),
    /**
     * 4 ��Ƶ��Ϣ
     */
    Video("video"),
    /**
     * 5 С��Ƶ��Ϣ
     */
    ShortVideo("shortvideo"),
    /**
     * 6 ����λ����Ϣ
     */
    Location("location"),
    /**
     * 7 ������Ϣ
     */
    Link("link"),
    /**
     * �¼���Ϣ
     */
    Event("event"),
    /**
     * ������Ϣ
     */
    Music("music"),
    /**
     * ͼ����Ϣ
     */
    News("news");
    private String value = "";

    MsgType(String value) {
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