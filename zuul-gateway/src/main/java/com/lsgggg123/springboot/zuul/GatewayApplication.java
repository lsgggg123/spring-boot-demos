package com.lsgggg123.springboot.zuul;

/**
 * zuul启动类
 * 启动后访问http://localhost:8088/fc/feign可以反向代理到http://localhost:8080/feign
 * 配置在application.yml zuul.routes.NAME.path -> application.yml zuul.routes.NAME.url
 * Created by liushun on 16/6/3.
 */
import com.lsgggg123.springboot.zuul.filter.post.SimplePostFilter1;
import com.lsgggg123.springboot.zuul.filter.post.SimplePostFilter2;
import com.lsgggg123.springboot.zuul.filter.pre.SimplePreFilter1;
import com.lsgggg123.springboot.zuul.filter.pre.SimplePreFilter2;
import com.lsgggg123.springboot.zuul.filter.route.SimpleRouteFilter1;
import com.lsgggg123.springboot.zuul.filter.route.SimpleRouteFilter2;
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
    public SimplePreFilter1 simpleFilter1() {
        return new SimplePreFilter1();
    }

    @Bean
    public SimplePreFilter2 simpleFilter2() {
        return new SimplePreFilter2();
    }

    @Bean
    public SimplePostFilter1 simplePostFilter1() {
        return new SimplePostFilter1();
    }

    @Bean
    public SimplePostFilter2 simplePostFilter2() {
        return new SimplePostFilter2();
    }

    @Bean
    public SimpleRouteFilter1 simpleRouteFilter1() {
        return new SimpleRouteFilter1();
    }

    @Bean
    public SimpleRouteFilter2 simpleRouteFilter2() {
        return new SimpleRouteFilter2();
    }
}
