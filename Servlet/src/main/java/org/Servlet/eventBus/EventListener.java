package org.Servlet.eventBus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

import lombok.extern.log4j.Log4j;

/*@Log4j*/
public class EventListener {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Subscribe
	public void listen(Event event) {
		log.info("单例receive message" + event);
	}

	@Subscribe
	public void listen(String message) {
		log.info("单例订阅" + message);
	}
}
