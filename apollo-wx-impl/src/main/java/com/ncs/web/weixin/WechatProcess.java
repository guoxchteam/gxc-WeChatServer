package com.ncs.web.weixin;

import java.util.Date;

/**
 * ΢��xml��Ϣ���������߼���
 * 
 * @author pamchen-1
 * 
 */
public class WechatProcess {
	/**
	 * ��������xml����ȡ���ܻظ������ͨ��ͼ�������api�ӿڣ�
	 * 
	 * @param xml
	 *            ���յ���΢������
	 * @return ���յĽ��������xml��ʽ���ݣ�
	 */
	public String processWechatMag(String xml) {
		/** ����xml���� */
		ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);

		/** ���ı���ϢΪ��������ͼ�������api�ӿڣ���ȡ�ظ����� */
		String result = "";
		if ("text".endsWith(xmlEntity.getMsgType())) {
			// result = new
			// TulingApiProcess().getTulingResult(xmlEntity.getContent());
			result = "���";
		}

		/**
		 * ��ʱ������û�������ǡ���á����ھ�������Ĺ���֮��resultΪ����Ҳ�á����Ƶ�����
		 * ��Ϊ���ջظ���΢�ŵ�Ҳ��xml��ʽ�����ݣ�������Ҫ�����װΪ�ı����ͷ�����Ϣ
		 */
		result = new FormatXmlProcess().formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);

		return result;
	}
}