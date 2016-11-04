package com.goopal.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * 
 * @author Administrator
 *
 */
//@Configuration
//@EnableScheduling
public class SchedulingConfig {

//	@Autowired
//	MailService mailService;

//	@Scheduled(cron = "0/30 * * * * ?") // 每20秒执行一次
	public void exportWeeklyReport() {
		System.out.println(">>>>>>>>> exportWeeklyReport start");
		System.out.println(">>>>>>>>> exportWeeklyReport end");
	}

//	@Scheduled(cron = "0 0/2 * * * ?") // 每天3点执行一次
	public void sendMail() {
		System.out.println(">>>>>>>>> sendMail start");
		System.out.println(">>>>>>>>> sendMail end");
	}
}
