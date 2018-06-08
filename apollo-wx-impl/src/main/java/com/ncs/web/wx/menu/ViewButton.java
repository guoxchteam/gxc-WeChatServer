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
 * ��תURL
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class ViewButton extends SingleButton {

    /**
     * view���ͱ���.��ҳ���ӣ��û�����˵��ɴ����ӣ�������256�ֽ�
     */
    private String url;

    public ViewButton() {
    }

    public ViewButton(String name, String url) {
        this.setName(name);
        this.url = url;
    }

    public String getType() {
        return ButtonType.View.toString();
    }

    /**
     * ��ȡ ��ҳ���� <p>view���ͱ���.��ҳ���ӣ��û�����˵��ɴ����ӣ�������256�ֽ�</p>
     *
     * @return ��ҳ����
     */
    public String getUrl() {
        return url;
    }

    /**
     * ���� ��ҳ���� <p>view���ͱ���.��ҳ���ӣ��û�����˵��ɴ����ӣ�������256�ֽ�</p>
     *
     * @param url ��ҳ����
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
