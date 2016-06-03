package com.lsgggg123.springboot.feign.action;

import com.lsgggg123.springboot.feign.feignclient.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ServiceClient serviceClient;

    @RequestMapping("/feign")
    public String remoteService() {
        return serviceClient.service();
    }

}
