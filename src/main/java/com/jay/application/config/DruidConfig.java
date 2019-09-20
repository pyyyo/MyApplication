package com.jay.application.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * druid
 * @author jay
 *
 */
@Configuration
@ServletComponentScan 
public class DruidConfig {
	/**
	 * 加载时读取指定的配置信息,前缀为spring.datasource.druid
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource") 
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
}
