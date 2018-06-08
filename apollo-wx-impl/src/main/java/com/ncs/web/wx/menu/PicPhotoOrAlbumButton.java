package com.ncs.web.wx.menu;

/**
 * ���ջ�����ᷢͼ
 *
 * @author qsyang
 * @version 1.0
 */
public class PicPhotoOrAlbumButton extends SingleButton {

    /**
     * ���ͱ���.�˵�KEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ�
     */
    private String key;

    public PicPhotoOrAlbumButton() {
    }

    public PicPhotoOrAlbumButton(String key) {
        this.key = key;
    }

    public PicPhotoOrAlbumButton(String name, String key) {
        this.setName(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Pic_Photo_OR_Album.toString();
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
