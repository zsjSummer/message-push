package com.zms.push.messagepush.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @ClassName ThreadPoolTaskSchedulerConfig
 * @Description 定时任务配置
 * @Author zmszsj
 * @Date 2019/2/26 10:32
 * @Version 1.0
 **/
@Configuration
public class ThreadPoolTaskSchedulerConfig {
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		return new ThreadPoolTaskScheduler();
	}
}
