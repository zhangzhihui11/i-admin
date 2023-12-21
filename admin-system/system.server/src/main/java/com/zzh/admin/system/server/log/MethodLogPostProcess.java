package com.zzh.admin.system.server.log;

import com.zzh.admin.common.base.annotations.Log;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.InitializingBean;

import java.lang.annotation.Annotation;

public class MethodLogPostProcess extends AbstractBeanFactoryAwareAdvisingPostProcessor implements InitializingBean {

    private static final Class<? extends Annotation> LOG_TYPE = Log.class;


    @Override
    public void afterPropertiesSet() {
        Pointcut pointcut = new AnnotationMatchingPointcut(LOG_TYPE,  true);
        advisor = new DefaultPointcutAdvisor(pointcut, new MethodLogInterceptor());
    }
}
