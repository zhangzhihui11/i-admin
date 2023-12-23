package com.zzh.admin.common.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DictConvertAdvice {

    @Pointcut("@annotation(com.zzh.admin.common.base.annotations.DictConvert)")
    private void pointcut() {}

    @Around("pointcut()")
    public Object aroundProcess(ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }
}
