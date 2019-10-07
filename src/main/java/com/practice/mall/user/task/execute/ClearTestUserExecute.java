package com.practice.mall.user.task.execute;

import com.practice.mall.user.task.ClearTestUserJob;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import java.util.Calendar;

@Configuration
public class ClearTestUserExecute {

    @Bean("clearTestUser")
    public JobDetailFactoryBean clearTestUserJobDetail() {

        return buildJobDetailFactoryBean();
    }

    private JobDetailFactoryBean buildJobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ClearTestUserJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean("clearTestUserTrigger")
    public CronTriggerFactoryBean clearTestUserTrigger(@Qualifier("clearTestUser") JobDetail jobDetail) {

        return buildCronTriggerFactoryBean(jobDetail);
    }

    private CronTriggerFactoryBean buildCronTriggerFactoryBean(@Qualifier("clearTestUser") JobDetail jobDetail) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();

        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression("0/3 * * ? * * *");//every 3 seconds

        factoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);

        factoryBean.setStartDelay(0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);//to round to a second, because executing every 2 seconds

        factoryBean.setStartTime(calendar.getTime());
        return factoryBean;
    }
}
