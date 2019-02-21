package com.zms.push.messagepush.controller;

import com.zms.push.messagepush.MessagePushApplication;
import com.zms.push.messagepush.domain.PingDomain;
import com.zms.push.messagepush.domain.RegistKeyDomain;
import com.zms.push.messagepush.dto.ResultDto;
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
	@RequestMapping("register")
	public ResultDto<RegistKeyDomain> register(@RequestParam("devicetoken") String devicetoken){
		// 防止多线程不安全
		synchronized (MessagePushApplication.tokens){
			MessagePushApplication.tokens.add(devicetoken);
		}
		//这里暂时只是将设备的token返回回去了，实际上可以像源码一样加密一个key然后返回（源码格式要求，可以用不到）
		RegistKeyDomain registKey = new RegistKeyDomain(devicetoken);
		return new ResultDto<>(200,registKey,"注册成功");
	}

	@RequestMapping("ping")
	public ResultDto<PingDomain> ping(@RequestBody(required = false) String data){
		PingDomain ping = new PingDomain("1.0.0");
		return new ResultDto<>(200,ping,"pong");
	}

	/**
	 r.Get("/ping", http.HandlerFunc(ping))
	 r.Post("/ping", http.HandlerFunc(ping))

	 r.Get("/register", http.HandlerFunc(register))
	 r.Post("/register", http.HandlerFunc(register))
	 */
}
