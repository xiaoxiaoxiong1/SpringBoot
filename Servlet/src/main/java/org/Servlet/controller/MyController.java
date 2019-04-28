package org.Servlet.controller;

import java.util.Optional;

import org.Servlet.eventBus.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/serlvet3")
/*@Slf4j*/
public class MyController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@ApiOperation(value="执行测试", notes="测试发送消息")
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "message", value = "消息", required = false, dataType = "String",paramType = "query" ),
		@ApiImplicitParam(name = "name", value = "mingzi", required = false, dataType = "String",paramType = "query")
})
	//@ApiImplicitParam(name = "event", value = "message实体", required = false, dataType = "event")
	@RequestMapping("/request")
	@ResponseBody
	public Event testServlet3_0(Event event){
		log.info("请求信息{}",Optional.ofNullable(event.getMessage()));
		return event;
	}
	
	
	@RequestMapping("/home")
	public String testServlet(Event event){
		log.info("请求信息{}",Optional.ofNullable(event.getMessage()));
		return "home";
	}
}
