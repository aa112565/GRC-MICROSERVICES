package com.grc.email.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.grc.email.service.EmailService;


@Component
public class EmailScheduler {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmailScheduler.class);
	
	@Resource
	EmailService emailService;

	@Scheduled(cron = "0 41 18 * * ?")
	public void triggerScheduledEmails() {
		try {
			emailService.triggerScheduledEmails();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date now = new Date();
			String strDate = sdf.format(now);
			LOG.info("Java cron job expression:: " + strDate);
		} catch (Exception ex) {
			LOG.error("Error occurred when running the scheduled mail cron job");
			ex.printStackTrace();
		}
	}   
}
