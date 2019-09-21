package com.jay.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * SpringBoot 启动类
 * @author jay
 *
 */
@SpringBootApplication
public class MyApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}
