package com.zzh.admin.common.mybatis.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.zzh.admin.common.mybatis.mapper"})
@ComponentScan(basePackages = {"com.zzh.admin.common.mybatis"})
public class CommonMybatisAutoConfiguration {
}
