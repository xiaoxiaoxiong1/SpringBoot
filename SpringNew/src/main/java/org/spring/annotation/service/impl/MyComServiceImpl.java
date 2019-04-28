package org.spring.annotation.service.impl;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.annotation.Mycomponent;
import org.spring.annotation.service.MyComService;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
@Mycomponent
public class MyComServiceImpl implements MyComService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override

    public void doSomething() {
        logger.error("my compent do something");
    }
}
