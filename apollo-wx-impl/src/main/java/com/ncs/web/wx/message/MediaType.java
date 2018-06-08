package com.ncs.web.wx.message;

/**
 *
 * �ز�����
 *
 * @author qsyang
 */
public enum MediaType {

    /**
     * ͼƬ
     */
    Image("image"),
    /**
     * ����
     */
    Voice("voice"),
    /**
     * ��Ƶ
     */
    Video("video"),
    /**
     * ����ͼ
     */
    Thumb("thumb");

    private String value = "";

    MediaType(String value) {
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