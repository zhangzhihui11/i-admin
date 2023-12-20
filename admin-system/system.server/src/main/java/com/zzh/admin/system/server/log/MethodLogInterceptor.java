package com.zzh.admin.system.server.log;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MethodLogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnVal = invocation.proceed();
        log.info(invocation.getMethod().getName()+ "cost " + (System.currentTimeMillis() - start) + " ms");
        return returnVal;
    }
}
