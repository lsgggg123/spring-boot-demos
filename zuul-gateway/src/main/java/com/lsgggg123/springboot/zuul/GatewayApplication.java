package com.lsgggg123.springboot.zuul;

/**
 * zuul启动类
 * 启动后访问http://localhost:8088/fc/feign可以反向代理到http://localhost:8080/feign
 * 配置在application.yml zuul.routes.NAME.path -> application.yml zuul.routes.NAME.url
 * Created by liushun on 16/6/3.
 */
import com.lsgggg123.springboot.zuul.filter.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

}
