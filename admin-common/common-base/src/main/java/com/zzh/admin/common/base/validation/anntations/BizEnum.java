package com.zzh.admin.common.base.validation.anntations;

import com.zzh.admin.common.base.validation.validator.BizEnumConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {BizEnumConstraintValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BizEnum {

    Class<?> enumType();

    String fieldName();

    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
