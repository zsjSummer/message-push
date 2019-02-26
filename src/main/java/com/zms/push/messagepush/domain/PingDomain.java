package com.zms.push.messagepush.domain;

import java.io.Serializable;

/**
 * @ClassName PingDomain
 * @Description 心跳检测bean
 * @Author zmszsj
 * @Date 2019/2/21 14:10
 * @Version 1.0
 **/
public class PingDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	private String version;

	public PingDomain() {
	}

	public PingDomain(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "PingDomain{" +
				"version='" + version + '\'' +
				'}';
	}
}
