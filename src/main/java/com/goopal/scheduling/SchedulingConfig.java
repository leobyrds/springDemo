package com.goopal.scheduling;

import com.goopal.properties.CustomerProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定时任务
 * 
 * @author Administrator
 *
 */
//@EnableConfigurationProperties
//@Configuration
//@EnableScheduling
public class SchedulingConfig {
//	@Autowired
//	MailService mailService;
	@Autowired
	private CustomerProperties customerProperties;

//	@Scheduled(cron = "0/10 * * * * ?")
	public void print(){
        System.out.println(customerProperties.getFile().get(0));
        System.out.println(customerProperties.getFileFolder());
	}

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
