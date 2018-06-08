package com.ncs.web.wx.message;

import java.util.TreeMap;

public class TemplateMsg implements java.io.Serializable {
	private String touser; // ������openid

	private String template_id; // ģ��ID
	
	private String url; // ģ����ת����

	private TreeMap<String, TreeMap<String, String>> data; // data����

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TreeMap<String, TreeMap<String, String>> getData() {
		return data;
	}

	public void setData(TreeMap<String, TreeMap<String, String>> data) {
		this.data = data;
	}

	/**
	 * ����
	 * 
	 * @param value
	 * @param color
	 *            �ɲ���
	 * @return
	 */
	public static TreeMap<String, String> item(String value, String color) {
		TreeMap<String, String> params = new TreeMap<String, String>();
		params.put("value", value);
		params.put("color", color);
		return params;
	}
}
