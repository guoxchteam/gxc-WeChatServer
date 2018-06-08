package com.ncs.web.wx.service;

import java.io.Serializable;

/**
 * 微信Token
 * 
 * @author <a href="mailto:quanz@newcensoft.com.cn">James Quan</a><br>
 * @version 2016年8月9日 下午12:41:32
 */
public class AccessToken implements Serializable {

	private String token;
	private long expireTime;

	public AccessToken() {
		super();
	}

	public AccessToken(String token, long expireTime) {
		super();
		this.token = token;
		this.expireTime = expireTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}

}
