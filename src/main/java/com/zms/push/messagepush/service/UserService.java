package com.zms.push.messagepush.service;

import com.zms.push.messagepush.domain.UserDomain;
import com.zms.push.messagepush.dto.ResultDto;
import com.zms.push.messagepush.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserService
 * @Description 用户相关的service
 * @Author zmszsj
 * @Date 2019/2/26 13:58
 * @Version 1.0
 **/
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户注册
	 *
	 * @param userDomain-注册信息
	 * @return 注册结果
	 */
	public ResultDto<String> regist(UserDomain userDomain) {
		int flag = userMapper.addUser(userDomain);
		return new ResultDto<>(1, "注册成功");
	}

	/**
	 * 用户登录
	 *
	 * @param user-登录信息
	 * @return
	 */
	public ResultDto<UserDomain> login(Map<String, String> user) {
		UserDomain userDomain = userMapper.login(user.get("account"));
		if (null != userDomain) {
			if (new BCryptPasswordEncoder().matches(user.get("password"), userDomain.getPassword())) {
				return new ResultDto<>(1, userDomain, "登录成功");// 登录成功
			} else {
				return new ResultDto<>(-1, null, "密码错误");// 密码错误
			}
		}
		return new ResultDto<>(-1, null, "用户不存在");// 用户不存在
	}

	/**
	 * 用户登出
	 */
	public void logout() {

	}
}
