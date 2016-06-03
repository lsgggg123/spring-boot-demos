package com.lsgggg123.springboot.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liushun on 16/5/3.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan("com.lsgggg123.springboot.cloud.service")
public class CloudServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudServiceApplication.class, args);
    }
}
