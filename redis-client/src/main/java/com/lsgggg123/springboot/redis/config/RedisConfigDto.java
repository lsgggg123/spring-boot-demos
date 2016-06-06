package com.lsgggg123.springboot.redis.config;

/**
 *
 * Created by liushun on 16/6/6.
 */
public class RedisConfigDto {
    private String address;
    private int port;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
