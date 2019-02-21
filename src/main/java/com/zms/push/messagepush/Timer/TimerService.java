package com.zms.push.messagepush.Timer;

import com.zms.push.messagepush.service.HotSearchService;
import com.zms.push.messagepush.service.MessagePushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName TimerService
 * @Description 内置定时任务（后期修改为定时任务时间可自定义）
 * @Author zmszsj
 * @Date 2019/2/21 17:04
 * @Version 1.0
 **/
@Component
public class TimerService {

	@Autowired
	private HotSearchService hotSearchService;

	/**
	 * 内置微博热搜每天8点到23点每10分钟推送一次
	 */
	@Scheduled(cron = "0 0/10 8-23 * * *")
	public void weiboHotSearchPush(){
		MessagePushService messagePushService = new MessagePushService();
		messagePushService.push("热搜推送",hotSearchService.hotSearch());
	}
}
