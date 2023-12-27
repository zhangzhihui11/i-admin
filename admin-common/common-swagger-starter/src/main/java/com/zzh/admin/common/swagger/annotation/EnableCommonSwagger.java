package com.zzh.admin.common.swagger.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableCommonSwagger {

    String[] basePackages() default {};
}
