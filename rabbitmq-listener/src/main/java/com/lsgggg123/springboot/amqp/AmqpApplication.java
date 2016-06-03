package com.lsgggg123.springboot.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
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
@ComponentScan(value = {"com.lsgggg123.springboot.amqp"})
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableWebMvc
@EnableRabbit
public class AmqpApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }
}
