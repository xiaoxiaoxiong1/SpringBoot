package org.Servlet.controller;

import java.util.Optional;

import org.Servlet.eventBus.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller(value="test2")

/*@Slf4j*/
public class MyController2 {
	private Logger log=LoggerFactory.getLogger(this.getClass());


	
	@RequestMapping("/home")
	public String testServlet(Event event){
		log.info("请求信息{}",Optional.ofNullable(event.getMessage()));
		return "home";
	}
}
