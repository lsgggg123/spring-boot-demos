package com.lsgggg123.springboot.redis.action;

import com.lsgggg123.springboot.redis.service.RedisFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by liushun on 16/6/6.
 */
@RestController
public class RedisAction {
    @Autowired
    private RedisFacade redisFacade;

    @RequestMapping("redis")
    public Object test() {
        String key = "key";
        redisFacade.set(key, "a");
        return redisFacade.get(key);
    }
}
