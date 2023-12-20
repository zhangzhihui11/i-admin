package com.zzh.admin.system.server.test;

import com.zzh.admin.common.base.annotations.Log;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class MethodLogPostProcess extends AbstractBeanFactoryAwareAdvisingPostProcessor implements InitializingBean {

    private final Class<? extends Annotation> logType = Log.class;


    @Override
    public void afterPropertiesSet() {
        Pointcut pointcut = new AnnotationMatchingPointcut(logType, true);
        this.advisor = new DefaultPointcutAdvisor(pointcut, new MethodLogInterceptor());
    }
}
