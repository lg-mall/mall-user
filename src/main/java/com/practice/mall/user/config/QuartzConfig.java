package com.practice.mall.user.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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
