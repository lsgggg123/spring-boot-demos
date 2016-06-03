package com.lsgggg123.springboot.consul.config;

import com.enniu.cloud.services.testconsuldemo.client.TestConsulDemoClient;
import com.enniu.cloud.services.zmkm.client.ZmkmClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liushun on 16/5/23.
 */
@Configuration
public class RedisClientConfig {
    @Bean
    public ZmkmClient getZmkmClient() {
        return new ZmkmClient("dev");
    }

    @Bean
    public TestConsulDemoClient getTestConsulDemoClient() {
        return new TestConsulDemoClient("dev");
    }
}
