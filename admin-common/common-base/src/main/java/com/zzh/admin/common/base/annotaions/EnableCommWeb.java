package com.zzh.admin.common.base.annotaions;

import com.zzh.admin.common.base.configuration.CommonBaseWebImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(CommonBaseWebImportSelector.class)
public @interface EnableCommWeb {
}
