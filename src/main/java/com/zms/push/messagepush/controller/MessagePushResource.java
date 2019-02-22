package com.zms.push.messagepush.controller;

import com.zms.push.messagepush.domain.MessageDomain;
import com.zms.push.messagepush.domain.PushResultDomain;
import com.zms.push.messagepush.dto.ResultDto;
import com.zms.push.messagepush.service.MessagePushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MessagePushResource
 * @Author zmszsj
 * @Version 1.0.0
 * @Description 消息推送接口
 * @CreateTime 2019/2/21 12:55
 */

@RestController
@RequestMapping("/push")
public class MessagePushResource {
	private static final Logger logger = LoggerFactory.getLogger(MessagePushResource.class);

	@Autowired
	private MessagePushService messagePushService;

	/**
	 * 后台推送内容
	 *
	 * @param title-待推送的标题
	 * @param content-待推送的内容
	 */
	@GetMapping("/{title}/{content}")
	public ResultDto<PushResultDomain> push(@PathVariable("title") String title, @PathVariable("content") String content) {
		logger.info("消息推送 接口：/push/{title}/{content} 方法名：push 【标题：{} 内容：{}】", title, content);
		return messagePushService.push(title, content);
	}

	/**
	 * 后台推送内容
	 *
	 * @param content
	 * @return
	 */
	@GetMapping("/{content}")
	public ResultDto<PushResultDomain> push(@PathVariable("content") String content) {
		logger.info("消息推送 接口：/push/{content} 方法名：push 推送内容：{}", content);
		return messagePushService.push("", content);
	}

	/**
	 * 后台推送内容
	 *
	 * @param message 待推送的内容
	 */
	@PostMapping("/")
	public ResultDto<PushResultDomain> push(@RequestBody(required = false) MessageDomain message) {
		logger.info("消息推送 接口：/push/ 方法名：push 推送消息：{}", message);
		return messagePushService.pushService(message);
	}
}
