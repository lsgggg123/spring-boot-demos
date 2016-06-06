package com.lsgggg123.springboot.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;

/**
 *
 * Created by liushun on 16/6/6.
 */
@Component
@ConfigurationProperties(prefix = "redis")
@EnableConfigurationProperties(RedisCongfig.class)
public class RedisCongfig {
    private int max_idle;
    private int max_total;
    private long max_wait;
    private boolean testOnBorrow;
    private List<RedisConfigDto> clusterServers;


    @Bean
    public JedisCluster jedisCluster() {
        JedisCluster jc = null;
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(max_wait);
            config.setMaxIdle(max_idle);
            config.setMaxTotal(max_total);
            config.setTestOnBorrow(testOnBorrow);

            if (clusterServers != null && !clusterServers.isEmpty()) {
                HashSet<HostAndPort> nodes = new HashSet<>();
                for (RedisConfigDto entity : clusterServers) {
                    nodes.add(new HostAndPort(entity.getAddress(), entity.getPort()));
                }
                jc = new JedisCluster(nodes);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return jc;
        }
    }

    public int getMax_idle() {
        return max_idle;
    }

    public void setMax_idle(int max_idle) {
        this.max_idle = max_idle;
    }

    public int getMax_total() {
        return max_total;
    }

    public void setMax_total(int max_total) {
        this.max_total = max_total;
    }

    public long getMax_wait() {
        return max_wait;
    }

    public void setMax_wait(long max_wait) {
        this.max_wait = max_wait;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public List<RedisConfigDto> getClusterServers() {
        return clusterServers;
    }

    public void setClusterServers(List<RedisConfigDto> clusterServers) {
        this.clusterServers = clusterServers;
    }
}
