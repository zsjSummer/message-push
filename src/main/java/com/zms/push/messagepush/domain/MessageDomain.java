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
	//推送包含的 url
	private String url;

	public MessageDomain() {
	}

	public MessageDomain(String title, String content, String url) {
		this.title = title;
		this.content = content;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MessageDomain that = (MessageDomain) o;

		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		if (content != null ? !content.equals(that.content) : that.content != null) return false;
		return url != null ? url.equals(that.url) : that.url == null;
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (url != null ? url.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "MessageDomain{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
