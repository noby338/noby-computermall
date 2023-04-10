package com.woniuxy.storehousemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.woniuxy.storehousemanage.dao")
@EnableDiscoveryClient
@EnableFeignClients
//@SpringBootApplication
//该注解的意思是排除数据源自动配置，通过配置类手动配置DataSourceAutoConfiguration
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StorehouseManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorehouseManageApplication.class, args);
    }

}