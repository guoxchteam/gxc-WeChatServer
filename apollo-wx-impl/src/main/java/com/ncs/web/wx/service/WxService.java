package com.ncs.web.wx.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.ncs.web.wx.menu.SingleButton;
import com.ncs.web.wx.message.TemplateMsg;

/**
 * 微信接口服务
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月5日 下午3:10:52
 */
public interface WxService {

	/**
	 * 检查微信服务地址的有效性，加密/校验流程如下：
	 * <ul>
	 * <li>1. 将token、timestamp、nonce三个参数进行字典序排序
	 * <li>2. 将三个参数字符串拼接成一个字符串进行sha1加密
	 * <li>3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * </ul>
	 * 
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return 地址有效则返回{@code true}，否则返回{@code false}
	 */
	public boolean checkSignature(String signature, String timestamp, String nonce);

	/**
	 * 获取Access Token
	 * 
	 * @return
	 */
	public AccessToken getAccessToken();

	/**
	 * 保存新的AccessToken
	 * 
	 * @param token
	 */
	public void setAccessToken(AccessToken token);

	public void createMenu(SingleButton[] buttons) throws IOException;

	/**
	 * 通过向微信公众平台申请模板，来获取模板id
	 * 
	 * @return
	 * @throws Exception
	 */
	public JsonNode getAllPrivateTemplate() throws Exception;

	/**
	 * 发送模板消息
	 * 
	 * @param wechatTemplateMsg
	 *            模板消息对象
	 * 
	 * @throws Exception
	 */
	public void sendTemplateMsg(TemplateMsg wechatTemplateMsg) throws Exception;
	/**
	 * 
	 * @param openId 微信
	 * @return 用户头像url，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 * @throws Exception
	 */
	public String getWeiXinHeadImgUrl(String openId) throws Exception;
}
