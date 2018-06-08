package com.ncs.web.wx.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.ncs.web.wx.menu.SingleButton;
import com.ncs.web.wx.message.TemplateMsg;

/**
 * ΢�Žӿڷ���
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016��8��5�� ����3:10:52
 */
public interface WxService {

	/**
	 * ���΢�ŷ����ַ����Ч�ԣ�����/У���������£�
	 * <ul>
	 * <li>1. ��token��timestamp��nonce�������������ֵ�������
	 * <li>2. �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
	 * <li>3. �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
	 * </ul>
	 * 
	 * @param signature
	 *            ΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce����
	 * @param timestamp
	 *            ʱ���
	 * @param nonce
	 *            �����
	 * @return ��ַ��Ч�򷵻�{@code true}�����򷵻�{@code false}
	 */
	public boolean checkSignature(String signature, String timestamp, String nonce);

	/**
	 * ��ȡAccess Token
	 * 
	 * @return
	 */
	public AccessToken getAccessToken();

	/**
	 * �����µ�AccessToken
	 * 
	 * @param token
	 */
	public void setAccessToken(AccessToken token);

	public void createMenu(SingleButton[] buttons) throws IOException;

	/**
	 * ͨ����΢�Ź���ƽ̨����ģ�壬����ȡģ��id
	 * 
	 * @return
	 * @throws Exception
	 */
	public JsonNode getAllPrivateTemplate() throws Exception;

	/**
	 * ����ģ����Ϣ
	 * 
	 * @param wechatTemplateMsg
	 *            ģ����Ϣ����
	 * 
	 * @throws Exception
	 */
	public void sendTemplateMsg(TemplateMsg wechatTemplateMsg) throws Exception;
	/**
	 * 
	 * @param openId ΢��
	 * @return �û�ͷ��url�����һ����ֵ����������ͷ���С����0��46��64��96��132��ֵ��ѡ��0����640*640������ͷ�񣩣��û�û��ͷ��ʱ����Ϊ�ա����û�����ͷ��ԭ��ͷ��URL��ʧЧ��
	 * @throws Exception
	 */
	public String getWeiXinHeadImgUrl(String openId) throws Exception;
}
