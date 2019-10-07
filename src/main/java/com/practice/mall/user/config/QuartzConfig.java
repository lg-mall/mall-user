package com.practice.mall.user.config;

import com.zaxxer.hikari.HikariDataSource;
import org.quartz.Scheduler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AbstractDependsOnBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.quartz.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
public class QuartzConfig {

    @Bean("quartzDataSource")
    @ConfigurationProperties("mall-user.quartz.datasource")
    @QuartzDataSource
    public HikariDataSource quartzDataSource() {
        return new HikariDataSource();
    }

    @Bean("quartzTransactionManager")
    public DataSourceTransactionManager quartzTransactionManager(@Qualifier("quartzDataSource") DataSource quartzDataSource) {
        return new DataSourceTransactionManager(quartzDataSource);
    }

    @Bean
    public SchedulerFactoryBeanCustomizer schedulerFactoryBeanCustomizer(@QuartzDataSource DataSource dataSource,
                                                                         @Qualifier("quartzTransactionManager") PlatformTransactionManager transactionManager) {
        return schedulerFactoryBean -> {
            schedulerFactoryBean.setDataSource(dataSource);
            schedulerFactoryBean.setTransactionManager(transactionManager);

        };
    }



}
