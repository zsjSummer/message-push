package com.zms.push.messagepush.controller;

import com.zms.push.messagepush.MessagePushApplication;
import com.zms.push.messagepush.domain.PingDomain;
import com.zms.push.messagepush.domain.RegistKeyDomain;
import com.zms.push.messagepush.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RegistResource
 * @Description 该类是 ping 和注册设备的接口类
 * @Author zmszsj
 * @Date 2019/2/21 14:23
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
public class RegistResource {

	private static final Logger logger = LoggerFactory.getLogger(RegistResource.class);

	@RequestMapping("register")
	public ResultDto<RegistKeyDomain> register(@RequestParam("devicetoken") String devicetoken) {
		logger.info("设备注册 接口：/register 方法名：register 设备token：{}", devicetoken);
		// 防止多线程不安全
		synchronized (MessagePushApplication.tokens) {
			if (!MessagePushApplication.tokens.contains(devicetoken)) {
				MessagePushApplication.tokens.add(devicetoken);

			}
		}
		//这里暂时只是将设备的token返回回去了，实际上可以像源码一样加密一个key然后返回（源码格式要求，可以用不到）
		RegistKeyDomain registKey = new RegistKeyDomain(devicetoken);
		return new ResultDto<>(200, registKey, "注册成功");
	}

	@RequestMapping("ping")
	public ResultDto<PingDomain> ping(@RequestBody(required = false) String data) {
		logger.info("服务器检测 接口：/ping 方法名：ping");
		PingDomain ping = new PingDomain("1.0.0");
		return new ResultDto<>(200, ping, "pong");
	}
}
