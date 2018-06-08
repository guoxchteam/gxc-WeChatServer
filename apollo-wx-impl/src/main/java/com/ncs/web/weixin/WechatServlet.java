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
 * 微信服务端收发消息接口
 * 
 * @author pamchen-1
 * 
 */
public class WechatServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce"); // 随机数
		// 1.验证消息真实性
		// http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
		// URL为http://www.weixin4j.org/api/公众号
		// 成为开发者验证
		String echostr = request.getParameter("echostr"); //
		if (echostr != null && echostr.length() > 0) {
			// 确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
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

		/** 读取接收到的xml消息 */
		StringBuffer sb = new StringBuffer();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		String xml = sb.toString(); // 次即为接收到微信端发送过来的xml数据
		System.out.println("------------------------------------");
		System.out.println(xml);
		// 正常的微信处理流程
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