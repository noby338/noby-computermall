package com.woniuxy.storehousemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 配置包扫描，创建该包下接口的实现类
@MapperScan("com.woniuxy.storehousemanage.dao")
// 配置注解驱动
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class StorehouseManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorehouseManageApplication.class, args);
    }

}