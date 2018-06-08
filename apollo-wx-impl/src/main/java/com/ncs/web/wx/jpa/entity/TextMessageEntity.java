package com.ncs.web.wx.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "WX_INPUTMSG_TEXTMESSAGE")
@Entity
public class TextMessageEntity {
	@GeneratedValue
	@Id
	private Long id;
	/**
	 * 消息类型
	 */
	@Column(name = "MSGTYPE")
	private String MsgType;
	/**
	 * 开发者微信号
	 */
	@Column(name = "TOUSERNAME")
	private String ToUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	@Column(name = "FROMUSERNAME")
	private String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	@Column(name = "CREATETIME")
	private Long CreateTime;
	/**
	 * 消息id，64位整型
	 */
	@Column(name = "MSGID")
	private Long MsgId;
	/**
	 * 消息内容
	 */
	@Column(name = "CONTENT")
	private String Content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public TextMessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TextMessageEntity(Long id, String msgType, String toUserName, String fromUserName, Long createTime,
			Long msgId, String content) {
		super();
		this.id = id;
		MsgType = msgType;
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgId = msgId;
		Content = content;
	}

}