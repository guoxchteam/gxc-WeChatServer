package com.ncs.web.weixin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * Title: ΢�Ź���ƽ̨Token�㷨������
 * </p>
 *
 * <p>
 * Description: ΪӦ���ṩURL�㷨<br />
 * ���ݲ�ͬ��URL���ز�ͬ��Token������Ӧ��΢վ������<br />
 * ���磺Url:http://www.vzhanqun.com/api/tiexinqiao<br />
 * ��Ĭ��Token:ΪjEvQdLxi0PvtgK8N+HzUpA==<br />
 * �������õ�ϵͳToken��ͬ�����ı�
 * </p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class TokenUtil {

	// �˼�����Կ���ڼ��ܹ��ں�Token��һ�����ã������޸ģ�һ���޸ģ����й��ں���Ҫ������дToken
	private static String systemToken = "ncsweixin";

	/**
	 * ��ȡ�����ļ����õ�Token
	 *
	 * @return ΢վToken
	 */
	public static String get() {
		return systemToken;
	}

	/**
	 * ����/У���������£�
	 *
	 * <p>
	 * 1. ��token��timestamp��nonce�������������ֵ�������<br>
	 * 2.�����������ַ���ƴ�ӳ�һ���ַ�������sha1����<br>
	 * 3. �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��<br>
	 * </p>
	 *
	 * @param token
	 *            Token��֤��Կ
	 * @param signature
	 *            ΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce����
	 * @param timestamp
	 *            ʱ���
	 * @param nonce
	 *            �����
	 * @return ��֤�ɹ�����true,���򷵻�false
	 */
	public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
		List<String> params = new ArrayList<String>();
		params.add(token);
		params.add(timestamp);
		params.add(nonce);
		// 1. ��token��timestamp��nonce�������������ֵ�������
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
		// 3. �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
		return temp.equals(signature);
	}
}