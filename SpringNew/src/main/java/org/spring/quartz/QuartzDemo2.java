package org.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
public class QuartzDemo2 implements Job {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("start my job2");
    }
}
