package org.Servlet.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
 
/*
 * @EnableWebMvc //启动SpringMVC
 * 
 * @ComponentScan
 */ // 启动组件扫描
public class WebConfig extends WebMvcConfigurationSupport {

	// 配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		resolver.setExposeContextBeansAsAttributes(true);
		 //resolver.setCache(true);
	     resolver.setContentType("text/html;charset=UTF-8");
		return resolver;
	}

	// 配置静态资源的处理
	
/*	解读类似于 mvc:default-servlet-handler*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();// 对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	   registry.addResourceHandler("/").addResourceLocations("/**");
	  registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("classpath:/WEB-INF/views/");
	  //静态资源访问
	  registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}

}