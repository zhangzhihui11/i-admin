package com.zzh.admin.system.server.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MethodLogInterceptor implements MethodInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(MethodLogInterceptor.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnVal = invocation.proceed();
        LOG.info("{} cost {} ms", invocation.getMethod().getName(), System.currentTimeMillis() - start);
        return returnVal;
    }
}
