package com.ncs.web.wx.menu;

/**
 * ɨ�����¼�
 *
 * @author qsyang
 * @version 1.0
 */
public class ScancodePushButton extends SingleButton {

    /**
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    public ScancodePushButton() {
    }

    public ScancodePushButton(String key) {
        this.key = key;
    }

    public ScancodePushButton(String name, String key) {
        this.setName(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Scancode_Push.toString();
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
     * click���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�</p>
     *
     * @param key �˵�KEYֵ
     */
    public void setKey(String key) {
        this.key = key;
    }
}
