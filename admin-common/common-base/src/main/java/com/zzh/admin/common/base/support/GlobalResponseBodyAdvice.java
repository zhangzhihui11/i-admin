package com.zzh.admin.common.base.support;

import com.alibaba.fastjson2.JSON;
import com.zzh.admin.common.base.response.Resp;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (selectedContentType.toString().contains(MediaType.APPLICATION_JSON_VALUE)) {
            if (body instanceof Resp) {
                return body;
            }
            if (body instanceof String) {
                // 确认优化点
                return JSON.toJSONString(Resp.success(body));
            }
            return Resp.success(body);
        }
        return body;
    }
}
