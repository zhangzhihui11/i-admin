package com.zzh.admin.common.base.configuration;

import com.zzh.admin.common.base.interceptor.SimpleUserInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnClass(value = {WebMvcConfigurer.class})
public class WebMvcConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SimpleUserInterceptor())
                .addPathPatterns("/**")
                .order(Ordered.HIGHEST_PRECEDENCE);
    }
}
