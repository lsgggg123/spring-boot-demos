package com.lsgggg123.springboot.consul;

import com.netflix.config.ConfigurationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * Created by liushun on 16/5/23.
 */
@SpringBootApplication
@ComponentScan("com.lsgggg123.springboot.consul")
@EnableWebMvc
public class ConsulApplication {
    public static void main(String[] args) {
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.ZmkmApi.*.execution.isolation.thread.timeoutInMilliseconds",5000);
        ConfigurationManager.getConfigInstance().setProperty("hystrix.threadpool.default.coreSize",50);
        SpringApplication.run(ConsulApplication.class, args);
    }
}
