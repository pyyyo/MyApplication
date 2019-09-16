package com.jay.application.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ServletComponentScan 
public class DruidConfig {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource") //加载时读取指定的配置信息,前缀为spring.datasource.druid
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
}
