package com.lsgggg123.springboot.junit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 模拟的service
 * Created by liushun on 16/6/6.
 */
@Service
public class MockService {
    @Value("${junit.test}")
    private String test;

    public String getString() {
        return test;
    }
}
