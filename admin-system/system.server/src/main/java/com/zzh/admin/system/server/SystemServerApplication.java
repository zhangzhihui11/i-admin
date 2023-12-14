package com.zzh.admin.system.server;

import com.zzh.admin.common.base.annotaions.EnableCommWeb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCommWeb
@MapperScan(basePackages = {"com.zzh.admin.system.server.mapper"})
public class SystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemServerApplication.class, args);
    }
}
