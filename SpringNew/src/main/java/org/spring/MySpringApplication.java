package org.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySources(
		{

         @PropertySource("classpath:${spring.profiles.active}/springnew.properties"),

         @PropertySource("classpath:${spring.profiles.active}/springmail.properties")
      
		}
		)
@ComponentScan(basePackages = {"org.spring","org.mybatis"})	
@EnableAsync
@EnableCaching
public class MySpringApplication {


	public static void main(String[] args) {
        System.setProperty("spring.profiles.active","dev");
		SpringApplication.run(MySpringApplication.class, args);

	}
}
