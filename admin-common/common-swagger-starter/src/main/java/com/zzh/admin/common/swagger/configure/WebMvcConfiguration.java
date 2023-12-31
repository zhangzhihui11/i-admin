package com.zzh.admin.common.swagger.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Andon
 * 2021/12/29
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.
     addResourceHandler("/swagger-ui/**")
     .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
     .resourceChain(false);
     }

     @Override
     public void addViewControllers(ViewControllerRegistry registry) {
     registry.addViewController("/swagger-ui/")
     .setViewName("forward:/swagger-ui/index.html");
     }
}
