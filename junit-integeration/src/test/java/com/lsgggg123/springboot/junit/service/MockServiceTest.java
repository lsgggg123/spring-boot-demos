package com.lsgggg123.springboot.junit.service;

import com.lsgggg123.springboot.junit.JunitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * "spring.profiles.active:test" 来加载test配置
 * Created by liushun on 16/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = JunitApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0","spring.profiles.active:test"})
public class MockServiceTest {
    @Autowired
    private MockService mockService;

    @Test
    public void testGetString() throws Exception {
        String mockServiceString = mockService.getString();
        System.out.println(mockServiceString);
    }
}