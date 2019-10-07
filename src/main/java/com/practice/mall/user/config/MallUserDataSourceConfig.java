package com.practice.mall.user.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MallUserDataSourceConfig {

    private final  DataSourceConfigSupport configSupport;

    public MallUserDataSourceConfig( DataSourceConfigSupport configSupport) {
        this.configSupport = configSupport;
    }


    @Bean("userDataSource")
    @ConfigurationProperties(prefix = "mall-user.datasource.user")
    public HikariDataSource userDataSource() {
        return new HikariDataSource();
    }

    @Bean("userTransactionManager")
    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") HikariDataSource userDataSource) {

        return new DataSourceTransactionManager(userDataSource);
    }

    @Bean("userMybatisProperties")
    @ConfigurationProperties("mall-user.mybatis")
    public MybatisProperties mybatisProperties() {

        return new MybatisProperties();

    }

    @Bean("userSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource,
                                               @Qualifier("userMybatisProperties") MybatisProperties properties) throws Exception {
        SqlSessionFactoryBean factoryBean = configSupport.buildSqlSessionFactoryBean(dataSource, properties);
        return factoryBean.getObject();
    }


    @Bean("userSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory,
                                                 @Qualifier("userMybatisProperties") MybatisProperties properties) {
        return configSupport.buildSqlSessionTemplate(sqlSessionFactory, properties);

    }


}
