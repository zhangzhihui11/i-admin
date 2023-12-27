package com.zzh.admin.common.swagger.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@EnableOpenApi
public class SwaggerAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(SwaggerAutoConfiguration.class);

    private final ApplicationContext applicationContext;

    public SwaggerAutoConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Docket restApi() {
        ApiSelectorBuilder selectorBuilder = new Docket(DocumentationType.OAS_30)
                .groupName("标准接口")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .paths(PathSelectors.any());
        List<String> packages = getSpringBootBasePackage();
        for (String p : packages) {
            selectorBuilder.apis(RequestHandlerSelectors.basePackage(p));
        }
        return selectorBuilder.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建REST-ful APIs")
                .description("这里放描述")
                .termsOfServiceUrl("这里放URL")
                .contact(new Contact("张志辉", "https://blog.csdn.net/Kisushotto", "kisushotto@163.com"))
                .version("1.0")
                .build();
    }

    private List<String> getSpringBootBasePackage() {
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(SpringBootApplication.class);
        List<String> list = new ArrayList<>();
        beanMap.values().forEach(bean -> list.add(bean.getClass().getPackage().getName()));
        LOG.info("spring boot base package is {}" , list);
        return list;
    }
}
