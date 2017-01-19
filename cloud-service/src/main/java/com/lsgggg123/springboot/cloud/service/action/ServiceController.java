package com.lsgggg123.springboot.cloud.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * RefreshScope可以不重启应用刷新配置
 * Created by liushun on 16/5/3.
 */
@RestController
@RefreshScope
public class ServiceController {
    @Value("${mysqldb.datasource.url}")
    private String url;

    @Value("${mysqldb.datasource.username}")
    private String username;

    @Value("${mysqldb.datasource.password}")
    private String password;

    @Autowired
    private DiscoveryClient client;


    @RequestMapping("/service1")
    public String getConfig() {
        long start = System.currentTimeMillis();
        ServiceInstance instance = client.getLocalServiceInstance();
        // 随机睡眠1000毫秒以内
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - start;
        String service = "Hello World: "+ instance.getServiceId()+":"+instance.getHost()+":"+instance.getPort();
        return "1 Remote Hello~ " + username + ":" + password + "@" + url + "---" + cost + " | " + service;
    }

    @RequestMapping("/service2")
    public String getConfig2() {
        long start = System.currentTimeMillis();
        ServiceInstance instance = client.getLocalServiceInstance();
        // 随机睡眠1000毫秒以内
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - start;
        String service = "Hello World: "+ instance.getServiceId()+":"+instance.getHost()+":"+instance.getPort();
        return "2 Remote Hello~ " + username + ":" + password + "@" + url + "---" + cost + " | " + service;
    }
}
