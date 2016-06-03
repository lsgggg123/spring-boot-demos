package com.lsgggg123.springboot.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by liushun on 16/5/23.
 */
@SpringBootApplication
@ComponentScan(value = {"com.lsgggg123.springboot.quartz"})
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableWebMvc
public class QuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }
}
