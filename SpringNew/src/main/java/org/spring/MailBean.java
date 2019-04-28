package org.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Data
public class MailBean {

	private String host;
	private String username;
	private String password;
	private String mailTo;
	
}
