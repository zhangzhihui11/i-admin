package com.zzh.admin.common.base.configuration;

import com.zzh.admin.common.base.support.GlobalExceptionHandler;
import com.zzh.admin.common.base.support.GlobalResponseBodyAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(WebMvcConfiguration.class)
public class CommonBaseAutoConfiguration {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public GlobalResponseBodyAdvice globalResponseBodyAdvice() {

        return new GlobalResponseBodyAdvice();
    }

}
