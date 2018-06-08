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
 * ������¼�
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class ClickButton extends SingleButton {

    /**
     * click���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    public ClickButton() {
    }

    public ClickButton(String key) {
        this.key = key;
    }

    public ClickButton(String name, String key) {
        this.setName(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Click.toString();
    }

    /**
     * ��ȡ �˵�KEYֵ
     *
     * <p>click���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�</p>
     *
     * @return �˵�KEYֵ
     */
    public String getKey() {
        return key;
    }

    /**
     * ���� �˵�KEYֵ
     *
     * <p>click���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�</p>
     *
     * @param key �˵�KEYֵ
     */
    public void setKey(String key) {
        this.key = key;
    }
}
