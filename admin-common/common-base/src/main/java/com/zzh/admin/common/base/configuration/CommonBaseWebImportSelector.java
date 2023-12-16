package com.zzh.admin.common.base.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CommonBaseWebImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.zzh.admin.common.web.configure.WebMvcConfiguration",
                "com.zzh.admin.common.web.configure.handler.GlobalExceptionHandler",
                "com.zzh.admin.common.web.configure.advice.GlobalResponseBodyAdvice"
        };
    }
}
