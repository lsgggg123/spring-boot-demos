package com.lsgggg123.springboot.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * Created by liushun on 16/6/6.
 */
@SpringBootApplication
@ComponentScan(value = {"com.lsgggg123.springboot.junit"})
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableWebMvc
public class JunitApplication {
    public static void main(String[] args) {
        SpringApplication.run(JunitApplication.class, args);
    }
}
