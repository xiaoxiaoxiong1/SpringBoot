package org.spring.quartz;

import org.quartz.*;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */

@Component
public class QuartzManager {

    @Autowired
    private Scheduler scheduler;

    public void startJob() throws SchedulerException {
        startJobDemo(scheduler);
    }

    private void startJobDemo(Scheduler scheduler) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(QuartzJobDemo.class).withIdentity("job1", "group1").build();

        JobDetail jobDetail2 = JobBuilder.newJob(QuartzDemo2.class).withIdentity("job2", "group1").build();

        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1")
                .withSchedule(cronScheduleBuilder).build();

      scheduler.scheduleJob(jobDetail, cronTrigger);

        CronTrigger cronTrigger2 = TriggerBuilder.newTrigger().withIdentity("job2", "group1")
                .withSchedule(cronScheduleBuilder).build();

        scheduler.scheduleJob(jobDetail2, cronTrigger2);
        scheduler.start();
    }



    public void removeJob(String jobName, String groupName) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);
        try {
            if (checkExists(jobName, groupName)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkExists(String jobName, String groupName) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);
        return scheduler.checkExists(triggerKey);
    }

    public void updateJob(String jobName, String groupName, String time){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);
        try{
            int fixedRate = Integer.valueOf(time)*1000;
            SimpleTriggerImpl trigger = (SimpleTriggerImpl)scheduler.getTrigger(triggerKey);
            if(trigger.getRepeatInterval() != fixedRate){
                SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(fixedRate);
                Trigger newTrigger = TriggerBuilder.newTrigger().withIdentity(jobName, groupName)
                        .withSchedule(scheduleBuilder).build();

                removeJob(jobName, groupName);
                scheduler.rescheduleJob(triggerKey, newTrigger);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
