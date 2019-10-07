package com.practice.mall.user.task.execute;

import com.practice.mall.user.task.SimpleJob;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class SimpleExecute {

    @Bean(name = "simple")
    public JobDetailFactoryBean simpleJob() {
        return JobExecuteSupport.createJobDetail(SimpleJob.class, "Simple Demo Job");
    }

    @Bean("simpleTrigger")
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(@Qualifier("simple") JobDetail jobDetail) {
        return JobExecuteSupport.createTrigger(jobDetail, 2000, "Simple Demo Trigger");
    }
}
