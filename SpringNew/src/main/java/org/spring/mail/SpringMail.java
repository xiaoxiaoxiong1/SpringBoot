package org.spring.mail;

import org.spring.MailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SpringMail {
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private MailBean mailBean;
	//发送异步
	@Async
	public void sendMail(String content) {
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(mailBean.getUsername());
	        message.setTo(mailBean.getMailTo().split(","));
	        message.setSubject("邮件测试通知");
	        String a[]=new String[] {"1","1"};
	        message.setText(content);
	        sender.send(message);
	}
}
