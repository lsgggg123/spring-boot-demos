package com.lsgggg123.springboot.feign.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * Created by liushun on 16/5/6.
 */
@FeignClient("cloud-service")
public interface ServiceClient {
    @RequestMapping(value = "/service", method = GET)
    String service();
}
