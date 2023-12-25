package com.zzh.admin.common.base.log.configure;

import com.zzh.admin.common.base.log.MethodLogPostProcess;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MethodLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(search = SearchStrategy.CURRENT)
    public MethodLogPostProcess methodLogPostProcess() {

        return new MethodLogPostProcess();
    }
}
