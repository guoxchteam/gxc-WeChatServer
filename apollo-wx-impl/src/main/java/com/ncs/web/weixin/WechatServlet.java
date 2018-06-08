package com.ncs.web.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ΢�ŷ�����շ���Ϣ�ӿ�
 * 
 * @author pamchen-1
 * 
 */
public class WechatServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String signature = request.getParameter("signature");// ΢�ż���ǩ��
		String timestamp = request.getParameter("timestamp");// ʱ���
		String nonce = request.getParameter("nonce"); // �����
		// 1.��֤��Ϣ��ʵ��
		// http://mp.weixin.qq.com/wiki/index.php?title=��֤��Ϣ��ʵ��
		// URLΪhttp://www.weixin4j.org/api/���ں�
		// ��Ϊ��������֤
		String echostr = request.getParameter("echostr"); //
		if (echostr != null && echostr.length() > 0) {
			// ȷ�ϴ˴�GET��������΢�ŷ�������ԭ������echostr�������ݣ��������Ч����Ϊ�����߳ɹ����������ʧ��
			response.setContentType("text/plain");
			PrintWriter writer = response.getWriter();
			String token = TokenUtil.get();
			if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
				System.out.println("echo: " + echostr);
				writer.write(echostr);
			} else {
				writer.write("");
			}
			writer.flush();
		} else {
			doPost(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** ��ȡ���յ���xml��Ϣ */
		StringBuffer sb = new StringBuffer();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		String xml = sb.toString(); // �μ�Ϊ���յ�΢�Ŷ˷��͹�����xml����
		System.out.println("------------------------------------");
		System.out.println(xml);
		// ������΢�Ŵ�������
		String result = new WechatProcess().processWechatMag(xml);

		Writer writer = null;
		try {
			response.setContentType("text/xml; charset=utf-8");
			writer = new OutputStreamWriter(response.getOutputStream());
			writer.write(result);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}