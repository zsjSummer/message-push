package com.zms.push.messagepush.domain;

import java.io.Serializable;

/**
 * @ClassName MessageDomain
 * @Description 推送消息Bean
 * @Author zmszsj
 * @Date 2019/2/21 14:26
 * @Version 1.0
 **/
public class MessageDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	// 推送标题
	private String title;
	// 推送内容
	private String content;

	public MessageDomain() {
	}

	public MessageDomain(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
