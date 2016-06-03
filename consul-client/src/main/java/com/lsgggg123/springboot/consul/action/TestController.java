package com.lsgggg123.springboot.consul.action;

import com.enniu.cloud.services.testconsuldemo.client.TestConsulDemoClient;
import com.enniu.cloud.services.testconsuldemo.common.dto.TestConsulDemo;
import com.enniu.cloud.services.zmkm.client.ZmkmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liushun on 16/5/24.
 */
@RestController
public class TestController {
    @Autowired
    private ZmkmClient client;

    @Autowired
    private TestConsulDemoClient client2;

    @RequestMapping("test")
    @ResponseBody
    public Object test() {
        TestConsulDemo s = client2.getTestConsulDemo("s", 1L, true);
        return s;
    }
    @RequestMapping("test2")
    public void test2() {
        TestConsulDemo s = client2.getTestConsulDemo("s", 1L, true);
        client2.updateTestConsulDemo("s", "2",1L, s);
    }
}
