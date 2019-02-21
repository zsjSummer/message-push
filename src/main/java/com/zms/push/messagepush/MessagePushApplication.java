package com.zms.push.messagepush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MessagePushApplication {

	public static List<String> tokens = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(MessagePushApplication.class, args);
	}

}
