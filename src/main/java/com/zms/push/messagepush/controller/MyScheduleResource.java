package com.zms.push.messagepush.controller;

import com.zms.push.messagepush.service.TaskSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName MyScheduleResource
 * @Description 自定义定时任务接口层
 * @Author zmszsj
 * @Date 2019/2/26 11:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/myschedule")
public class MyScheduleResource {

	private static final Logger logger = LoggerFactory.getLogger(MyScheduleResource.class);

	@Autowired
	private TaskSchedulerService taskSchedulerService;

	/**
	 * 新增自定义定时任务
	 *
	 * @param data-任务详情
	 */
	@PostMapping("/add")
	public void addTask(@RequestBody Map<String, String> data) {
		logger.info("新增自定义定时任务 接口:/api/myschedule/add 任务详情:{}", data);
		taskSchedulerService.startScheduleTask("1", data.get("title"), data.get("content"), data.get("cron"));
	}

	/**
	 * 删除自定义定时任务
	 *
	 * @param taskId-任务ID
	 */
	@PostMapping("/stop/{taskId}")
	public void stopTask(@PathVariable("taskId") String taskId) {
		logger.info("删除自定义定时任务 接口:/api/myschedule/add 任务ID:{}", taskId);
		taskSchedulerService.stopScheduleTask(taskId);
	}
}
