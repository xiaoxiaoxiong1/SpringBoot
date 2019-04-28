package org.Servlet.eventBus;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
/*
@Log4j*/
public class LogExample {
	private Logger log=LoggerFactory.getLogger(this.getClass());
    EventBus eventBus=new EventBus("xionghao");
  @Test
  public  void testProduct() {
      EventBus eventBus=new EventBus("xionghao");
	  eventBus.register(new EventListener());
	  //eventBus.register(new MultiEventListener());
	  eventBus.post(new Event("test","")); //发布事件
   //  eventBus.post(new Event("world"));
      eventBus.post("!");
  }
  
  @Test
  public  void testConsume() {


	 UkInfo info=new UkInfo("test");
	  log.info(eventBus.toString());;
	  //eventBus.register(new EventListener());
	  eventBus.register(new MultiEventListener());
     // log.info(eventBus.identifier());

	  eventBus.post(new Event2("test111","")); //发布事件
      eventBus.post(info);
   //  eventBus.post(new Event("world"));
      eventBus.post("!");


  }
}