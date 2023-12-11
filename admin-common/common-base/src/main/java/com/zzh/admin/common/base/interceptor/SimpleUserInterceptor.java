package com.zzh.admin.common.base.interceptor;

import com.alibaba.fastjson2.JSON;
import com.zzh.admin.common.base.constants.RequestHeader;
import com.zzh.admin.common.base.entity.SimpleUser;
import com.zzh.admin.common.base.support.SimpleUserContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleUserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String jsonUser = request.getHeader(RequestHeader.SIMPLE_USER_KEY);
        if (StringUtils.isNotBlank(jsonUser)) {
            SimpleUserContextHolder.setSimpleUser(JSON.parseObject(jsonUser, SimpleUser.class));
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SimpleUserContextHolder.clearSimpleUserHolder();
    }
}
