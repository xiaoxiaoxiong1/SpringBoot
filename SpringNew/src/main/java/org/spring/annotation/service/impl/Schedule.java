package org.spring.annotation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
@Component
/*@EnableScheduling*/
public class Schedule {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

   // @Scheduled(cron = "* * * * * *")
    public void run(){
        logger.error("my shedule");
    }
}
