package com.ncs.web.wx.menu;

/**
 * ΢����ᷢͼ
 *
 * @author qsyang
 * @version 1.0
 */
public class PicWeixinButton extends SingleButton {

    /**
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    public PicWeixinButton() {
    }

    public PicWeixinButton(String key) {
        this.key = key;
    }

    public PicWeixinButton(String name, String key) {
        this.setName(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Pic_Weixin.toString();
    }

    /**
     * ��ȡ �˵�KEYֵ
     *
     * <p>
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�</p>
     *
     * @return �˵�KEYֵ
     */
    public String getKey() {
        return key;
    }

    /**
     * ���� �˵�KEYֵ
     *
     * <p>
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�</p>
     *
     * @param key �˵�KEYֵ
     */
    public void setKey(String key) {
        this.key = key;
    }
}
