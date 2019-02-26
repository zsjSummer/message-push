package com.zms.push.messagepush.controller;

import com.zms.push.messagepush.service.TaskSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName MyScheduleResource
 * @Description TODO
 * @Author zmszsj
 * @Date 2019/2/26 11:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/myschedule")
public class MyScheduleResource {

	@Autowired
	private TaskSchedulerService taskSchedulerService;

	@PostMapping("/add")
	public void addTask(@RequestBody Map<String,String> data){
		taskSchedulerService.startScheduleTask("1",data.get("title"),data.get("content"),data.get("cron"));
	}

	@PostMapping("/stop/{taskId}")
	public void stopTask(@PathVariable("taskId") String taskId){
		taskSchedulerService.stopScheduleTask(taskId);
	}
}
