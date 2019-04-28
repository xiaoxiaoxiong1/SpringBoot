package org.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class DemoMVCConfig implements WebMvcConfigurer{
	 @Override
	  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	       configurer.setDefaultTimeout(3*1000L); //tomcat默认10秒
	       configurer.setTaskExecutor(mvcTaskExecutor());//所借助的TaskExecutor
	   }
	   @Bean
	   public ThreadPoolTaskExecutor mvcTaskExecutor(){
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(10);
	        executor.setQueueCapacity(100);
	        executor.setMaxPoolSize(25);
	        return executor;

	    }

	   
}
