package com.lsgggg123.springboot.redis.service;

/**
 *
 * Created by liushun on 16/6/6.
 */
public interface RedisFacade {
	String set(String key, String value);
	String get(String key);
}
