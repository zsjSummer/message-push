package com.zms.push.messagepush.domain;

import java.io.Serializable;

/**
 * @ClassName UserDomain
 * @Description 用户bean
 * @Author zmszsj
 * @Date 2019/2/26 14:11
 * @Version 1.0
 **/
public class UserDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	// 用户id
	private String id;
	// 用户邮箱
	private String email;
	// 用户电话
	private String phone;
	// 用户密码
	private String password;
	// 用户别名
	private String nickName;

	public UserDomain() {
	}

	public UserDomain(String id, String email, String phone, String password, String nickName) {
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
