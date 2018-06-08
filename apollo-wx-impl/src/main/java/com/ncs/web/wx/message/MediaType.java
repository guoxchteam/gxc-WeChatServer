package com.ncs.web.wx.message;

/**
 *
 * ËØ²ÄÀàĞÍ
 *
 * @author qsyang
 */
public enum MediaType {

    /**
     * Í¼Æ¬
     */
    Image("image"),
    /**
     * ÓïÒô
     */
    Voice("voice"),
    /**
     * ÊÓÆµ
     */
    Video("video"),
    /**
     * ËõÂÔÍ¼
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