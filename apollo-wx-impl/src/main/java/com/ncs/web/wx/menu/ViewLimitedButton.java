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
 * �����ز�(ֻ����ͼ����Ϣ)
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class ViewLimitedButton extends SingleButton {

    /**
     * ���ͱ���.��ҳ���ӣ��û�����˵��ɴ����ӣ�������256�ֽ�
     */
    private String mediaId;

    public ViewLimitedButton() {
    }

    public ViewLimitedButton(String name, String mediaId) {
        this.setName(name);
        this.mediaId = mediaId;
    }

    public String getType() {
        return ButtonType.View_Limited.toString();
    }

    /**
     * ��ȡ �������������زĽӿڷ��صĺϷ�media_id
     *
     * @return �������������زĽӿڷ��صĺϷ�media_id
     */
    public String getMedia_Id() {
        return mediaId;
    }

    /**
     * ���� �������������زĽӿڷ��صĺϷ�media_id
     *
     * @param url �������������زĽӿڷ��صĺϷ�media_id
     */
    public void setMedia_Id(String mediaId) {
        this.mediaId = mediaId;
    }
}
