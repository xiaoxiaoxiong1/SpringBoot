package org.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
@Configuration
@ConfigurationProperties(prefix = "springnew")
@Data
public class ConfigBean {
 private String name;
 private String password;
 
}
