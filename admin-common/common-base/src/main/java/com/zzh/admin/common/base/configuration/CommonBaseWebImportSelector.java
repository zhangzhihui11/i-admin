package com.zzh.admin.common.base.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CommonBaseWebImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.zzh.admin.common.base.configuration.WebMvcConfiguration",
                "com.zzh.admin.common.base.support.GlobalExceptionHandler",
                "com.zzh.admin.common.base.support.GlobalResponseBodyAdvice"
        };
    }
}
