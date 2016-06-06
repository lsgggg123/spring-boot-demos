package com.lsgggg123.springboot.redis.service.impl;

import com.lsgggg123.springboot.redis.service.RedisFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;


/**
 *
 * Created by liushun on 16/6/6.
 */
@Component
public class RedisFacadeImpl implements RedisFacade {

    private static final Logger logger = Logger.getLogger(RedisFacadeImpl.class);

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String set(String key, String value) {
        try {
            return jedisCluster.set(key, value);
        } catch (Exception e) {
            logger.error("RedisFacade set error,key=" + key + " value=" + value);
        }
        return null;
    }


    @Override
    public String get(String key) {
        try {
            return jedisCluster.get(key);
        } catch (Exception e) {
            logger.error("RedisFacade get error,key=" + key);
        }
        return null;
    }
}
