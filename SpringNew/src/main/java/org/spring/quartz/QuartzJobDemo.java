package org.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
public class QuartzJobDemo  implements Job{
    private static final Logger logger = LoggerFactory.getLogger(QuartzJobDemo.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        Thread current = Thread.currentThread();
        logger.info("QuartzJobDemo.execute 定时任务Quartz:"+current.getId()+ ",name:"+current.getName());
    }

}
