package com.zzh.admin.common.base.validation.validator;

import com.zzh.admin.common.base.exception.BizException;
import com.zzh.admin.common.base.validation.anntations.BizEnum;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class BizEnumConstraintValidator implements ConstraintValidator<BizEnum, Object> {

    private Class<?> enumType;

    private String fieldName;

    @Override
    public void initialize(BizEnum ann) {
        enumType = ann.enumType();
        fieldName = ann.fieldName();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return true;
        }
        if (!enumType.isEnum()) {
            throw new BizException(10400, "校验类为非枚举类");
        }
        Field field = ReflectionUtils.findField(enumType, fieldName);
        if (field == null) {
            throw new BizException(10400, "需要校验的字段不存在");
        }
        if (!Objects.equals(field.getType(), o.getClass())) {
            throw new BizException(10400, "校验字段类型不匹配");
        }
        Object[] values = enumType.getEnumConstants();
        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method method = ReflectionUtils.findMethod(enumType, getMethodName);
        if (method == null) {
            throw new BizException(10400, "未找对对应字段的get方法");
        }
        for (Object value : values) {
            try {
                Object res = method.invoke(value, (Object[]) null);
                if (Objects.equals(res, o)) {
                    return true;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new BizException(10400, "");
            }
        }

        return false;
    }
}
