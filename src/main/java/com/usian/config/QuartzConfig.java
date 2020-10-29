package com.usian.config;

import com.usian.factory.QuartzJobFactory;
import com.usian.task.OrderTask4Quartz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Title: QuartzConfig
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/10/28 14:34
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private QuartzJobFactory quartzJobFactory;
    /**
     * Job 任务对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean job = new JobDetailFactoryBean();
        job.setJobClass(OrderTask4Quartz.class);
        return job;
    }

    /**
     * trigger
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetailFactoryBean.getObject());
        trigger.setCronExpression("0/1 * * * * ?");
        return trigger;

    }


    public void test(){
        System.out.println("test--------");
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(cronTriggerFactoryBean.getObject());
        scheduler.setJobFactory(quartzJobFactory); // job 任务对象，注入到IOC
        return scheduler;

    }
}
