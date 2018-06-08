package com.ncs.web.wx.menu;

/**
 * ɨ�����ʾ
 *
 * @author qsyang
 * @version 1.0
 */
public class ScancodeWaitMsgButton extends SingleButton {

    /**
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    public ScancodeWaitMsgButton() {
    }

    public ScancodeWaitMsgButton(String key) {
        this.key = key;
    }

    public ScancodeWaitMsgButton(String name, String key) {
        this.setName(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Scancode_Waitmsg.toString();
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
