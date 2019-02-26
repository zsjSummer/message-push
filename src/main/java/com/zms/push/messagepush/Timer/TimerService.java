package com.zms.push.messagepush.Timer;

import com.zms.push.messagepush.service.HotSearchService;
import com.zms.push.messagepush.service.MessagePushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName TimerService
 * @Description 内置定时任务（后期修改为定时任务时间可自定义,内置定时器需要用户允许才推送）
 * @Author zmszsj
 * @Date 2019/2/21 17:04
 * @Version 1.0
 **/
@Component
public class TimerService {
	private static final Logger logger = LoggerFactory.getLogger(MessagePushService.class);

	@Autowired
	private HotSearchService hotSearchService;

	/**
	 * 内置微博热搜每天8点到23点每10分钟推送一次
	 */
//	@Scheduled(cron = "0/10 * * * * ?")
//	@Scheduled(cron = "0 0/10 8-23 * * *")
	public void weiboHotSearchPush(){
		logger.info("微博热搜定时推送任务 方法名:weiboHotSearchPush 间隔:10min");
		MessagePushService messagePushService = new MessagePushService();
		messagePushService.push("热搜推送",hotSearchService.hotSearch());
	}
}
