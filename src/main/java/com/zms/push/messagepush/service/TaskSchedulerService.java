package com.zms.push.messagepush.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @ClassName TaskSchedulerService
 * @Description 自定义定时任务的启停
 * @Author zmszsj
 * @Date 2019/2/26 10:36
 * @Version 1.0
 **/
@Service
public class TaskSchedulerService {

	private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerService.class);


	// 保存定时任务
	Map<String, ScheduledFuture<?>> scheduleMap = new ConcurrentHashMap<>();

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	@Autowired
	private MessagePushService messagePushService;

	public void startScheduleTask(String userId, String pushTitle, String pushContent, String cron) {
		ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(() -> {
			messagePushService.push(pushTitle,pushContent);
			logger.info("自定义定时任务 推送标题:{} 内容:{} cron:{}",pushTitle,pushContent,cron);
		}, new CronTrigger(cron));
		// 先存数据库，再添加到map里
		String taskId = UUID.randomUUID().toString();
		scheduleMap.put(taskId, future);
		logger.info("开始定时任务，任务ID:{} 当前总任务数:{}",taskId,scheduleMap.size());
	}

	public void stopScheduleTask(String taskId) {
		if (!StringUtils.isEmpty(taskId) && scheduleMap.get(taskId) != null) {
			// 取消定时任务，从任务列表移除
			scheduleMap.get(taskId).cancel(true);
			scheduleMap.remove(taskId);
			logger.info("取消定时任务，任务ID:{} 剩余定时任务数:{}",taskId,scheduleMap.size());
		}
	}
}
