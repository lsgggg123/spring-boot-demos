package com.lsgggg123.springboot.mybatis.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mapper路径
 * 注意!!! 由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MapperConfigurer {
    @Bean
    public MapperScannerConfigurer makeMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.lsgggg123.springboot.mybatis.dao.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
