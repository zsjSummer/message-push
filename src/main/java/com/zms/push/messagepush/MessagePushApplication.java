package com.zms.push.messagepush;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@MapperScan(basePackages= {"com.zms.push.messagepush.mapper"})
public class MessagePushApplication {

	public static List<String> tokens = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(MessagePushApplication.class, args);
	}

}
