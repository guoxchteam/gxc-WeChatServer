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

import java.util.ArrayList;
import java.util.List;

/**
 * ���Ӳ˵��İ�ť,�˰�ť�б��������Ӳ˵�
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class SingleButton extends BaseButton {

    public SingleButton() {
    }

    public SingleButton(String name) {
        this.setName(name);
    }

    /**
     * �Ӳ˵�(�˲˵���Ҫ�ֶ���ӣ�����get��set�����ܺ�΢�ŷ��ص�jsonһ��)
     */
    private List<SingleButton> sub_button;

    /**
     * ���� �Ӳ˵�
     *
     * @param sub_button �Ӳ˵�
     */
    public void setSub_button(List<SingleButton> sub_button) {
        this.sub_button = sub_button;
    }

    /**
     * ��ȡ �Ӳ˵�
     *
     * @return �Ӳ˵�
     */
    public List<SingleButton> getSub_button() {
        if (sub_button == null) {
            sub_button = new ArrayList<SingleButton>(0);
        }
        return this.sub_button;
    }
}
