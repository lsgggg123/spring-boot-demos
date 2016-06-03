package com.lsgggg123.springboot.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 程序入口
 * Created by liushun on 16/5/23.
 */
@SpringBootApplication
@ComponentScan(value = {"com.lsgggg123.springboot.mybatis"})
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableWebMvc
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class);
    }
}
