package org.Servlet.eventBus;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.eventbus.DeadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

import lombok.extern.log4j.Log4j;
import springfox.documentation.spring.web.json.Json;

@Log4j
public class MultiEventListener {
	//private Logger log=LoggerFactory.getLogger(this.getClass());
	@Subscribe
	public void listen(Event event) {
		log.info("多例 receive message" + event);
	}

	@Subscribe
	public void listen(String message) {
		log.info("多例订阅" + message);
	}

	@Subscribe
	public void listenDead(DeadEvent event){

		log.info("消息未使用任何订阅"+ event);
	}

}
