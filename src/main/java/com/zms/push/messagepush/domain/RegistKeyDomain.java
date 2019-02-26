package com.zms.push.messagepush.domain;

import java.io.Serializable;

/**
 * @ClassName RegistKeyDomain
 * @Description 设备注册bean
 * @Author zmszsj
 * @Date 2019/2/21 14:02
 * @Version 1.0
 **/
public class RegistKeyDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	private String key;

	public RegistKeyDomain() {
	}

	public RegistKeyDomain(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "RegistKeyDomain{" +
				"key='" + key + '\'' +
				'}';
	}
}
