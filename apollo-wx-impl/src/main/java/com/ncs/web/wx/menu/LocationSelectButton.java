package com.ncs.web.wx.menu;

/**
 * ���͵���λ��
 *
 * @author qsyang
 * @version 1.0
 */
public class LocationSelectButton extends SingleButton {

    /**
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    public LocationSelectButton() {
    }

    public LocationSelectButton(String key) {
        this.key = key;
    }

    public LocationSelectButton(String name, String key) {
        this.setName(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Location_Select.toString();
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
