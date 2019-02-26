package com.zms.push.messagepush.controller;

import com.zms.push.messagepush.domain.UserDomain;
import com.zms.push.messagepush.dto.ResultDto;
import com.zms.push.messagepush.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName UserResource
 * @Description 用户相关的controller层
 * @Author zmszsj
 * @Date 2019/2/26 13:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/user")
public class UserResource {

	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	/**
	 * 用户注册接口
	 *
	 * @param userDomain-用户注册信息
	 * @return 注册结果
	 */
	@PostMapping("/regist")
	public ResultDto<String> regist(UserDomain userDomain) {
		logger.info("用户注册 接口:/api/user/regist 注册信息:{}", userDomain);
		return userService.regist(userDomain);
	}

	/**
	 * 用户登录接口
	 *
	 * @param user-登录信息
	 * @return 登陆结果
	 */
	@PostMapping("/login")
	public ResultDto<UserDomain> login(@RequestBody Map<String, String> user) {
		logger.info("用户注册 接口:/api/user/login 登录信息:{}", user);
		return userService.login(user);
	}

	/**
	 * 用户登出
	 */
	@PostMapping("/logout")
	public void logout() {
		logger.info("用户注册 接口:/api/user/logout ");
	}
}
