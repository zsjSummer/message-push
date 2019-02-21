package com.zms.push.messagepush.Timer;

import com.zms.push.messagepush.service.HotSearchService;
import com.zms.push.messagepush.service.MessagePushService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName TimerService
 * @Description TODO
 * @Author zmszsj
 * @Date 2019/2/21 17:04
 * @Version 1.0
 **/
@Component
public class TimerService {
	@Scheduled(cron = "0/10 * * * * *")
	public void print(){
		HotSearchService hotSearchService = new HotSearchService();
		String content = hotSearchService.hotSearch();
		MessagePushService messagePushService = new MessagePushService();
		messagePushService.push("热搜推送",content);
	}
}
