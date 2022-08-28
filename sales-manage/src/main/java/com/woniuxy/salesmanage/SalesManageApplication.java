package com.woniuxy.salesmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.woniuxy.salesmanage.dao")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SalesManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesManageApplication.class, args);
    }

}