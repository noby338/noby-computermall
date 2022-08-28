package com.woniuxy.storehousemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.woniuxy.storehousemanage.dao")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class StorehouseManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorehouseManageApplication.class, args);
    }

}