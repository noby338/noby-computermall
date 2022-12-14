package com.woniuxy.cooperationmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.woniuxy.cooperationmanage.dao")
@EnableDiscoveryClient
@EnableFeignClients
//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CooperationManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooperationManageApplication.class, args);
    }

}