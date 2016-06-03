package com.lsgggg123.springboot.mybatis.controller;


import com.lsgggg123.springboot.mybatis.domain.Feed;
import com.lsgggg123.springboot.mybatis.service.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liushun on 16/1/31.
 * 提供RESTFul服务的Controller
 */
@RestController
@RequestMapping("/hello")
public class MyRestController {
    @Autowired
    private IFeedService feedService;

    @RequestMapping("/json")
    @ResponseBody
    public Map<String, Object> json(Integer userId) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Feed> feeds = feedService.findFeeds(userId);
        resultMap.put("feeds", feeds);
        return resultMap;
    }
}
