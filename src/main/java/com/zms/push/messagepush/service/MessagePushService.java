package com.zms.push.messagepush.service;

import com.zms.push.messagepush.MessagePushApplication;
import com.zms.push.messagepush.domain.MessageDomain;
import com.zms.push.messagepush.domain.PushResultDomain;
import com.zms.push.messagepush.dto.ResultDto;
import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessagePushService
 * @Description 消息推送的 Service 层
 * @Author zmszsj
 * @Date 2019/2/21 14:41
 * @Version 1.0
 **/
@Service
public class MessagePushService {
	private final int BADGE = 1;                                // 图标小红圈的数值
	private final String SOUND = "default";                     // 铃音
	private final String MSG_CERTIFICATE_PASSWORD = "bp";       // 导出证书时设置的密码
	private final String CERTIFICATE_PATH = "cert-20200229.p12";// 证书名

	/**
	 * 消息推送
	 *
	 * @param messageDomain-待推送的消息
	 */
	public ResultDto<PushResultDomain> pushService(MessageDomain messageDomain) {
		return push(messageDomain.getTitle(), messageDomain.getContent());
	}

	/**
	 * 消息推送
	 *
	 * @param title-标题
	 * @param message-消息
	 * @return
	 */
	public ResultDto<PushResultDomain> push(String title, String message) {
		// 定义设备数组
		List<Device> devices = new ArrayList<>();
		Resource resource = new ClassPathResource(CERTIFICATE_PATH);
		try {
			// 推送相关的设置
			PushNotificationPayload payload = new PushNotificationPayload();
			payload.badge(BADGE);                // 小红圈
			payload.addSound(SOUND);             // 声音
			payload.addCustomAlertTitle(title);  // 标题
			payload.addCustomAlertBody(message); // 消息内容
			// 推送服务管理
			PushNotificationManager pushManager = new PushNotificationManager();
			// false：表示的是产品测试推送服务 true：表示的是产品发布推送服务
			pushManager.initializeConnection(new AppleNotificationServerBasicImpl(resource.getInputStream(),
					MSG_CERTIFICATE_PASSWORD, true));
			// 开始推送消息
			for (String token : MessagePushApplication.tokens) {
				devices.add(new BasicDevice(token));
			}
			List<PushedNotification> notifications = pushManager.sendNotifications(payload, devices);
			// 获取推送成功/失败的个数
			List<PushedNotification> failedNotification = PushedNotification.findFailedNotifications(notifications);
			List<PushedNotification> successfulNotification = PushedNotification.findSuccessfulNotifications(notifications);
			// 关闭推送连接
			pushManager.stopConnection();
			return new ResultDto<>(200, new PushResultDomain(devices.size(), successfulNotification.size(),
					failedNotification.size()), "推送成功");
		} catch (Exception e) {
			return new ResultDto<>(400, new PushResultDomain(0, 0, 0), "推送失败");
		}
	}
}
