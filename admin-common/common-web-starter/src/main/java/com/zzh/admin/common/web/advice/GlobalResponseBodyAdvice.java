package com.zzh.admin.common.web.advice;

import com.alibaba.fastjson2.JSON;
import com.zzh.admin.common.base.response.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Value("${server.servlet.context-path}")
    private String servletContextPath;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getDeclaringClass().getName().contains("springfox");
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (selectedContentType.toString().contains(MediaType.APPLICATION_JSON_VALUE)) {
            if (isErrorPath(request)) {
                if (body instanceof Map) {
                    Map<?, ?> map = (Map<?,?>) body;
                    Integer code = (Integer) map.get("status");
                    String errorMessage = (String) map.get("error");
                    return Resp.buildResp(code, errorMessage, null);
                }

            } else {
                if (body instanceof Resp) {
                    return body;
                }
                if (body instanceof String) {
                    // 确认优化点
                    return JSON.toJSONString(Resp.success(body));
                }
                return Resp.success(body);
            }
        }
        return body;
    }

    private boolean isErrorPath(ServerHttpRequest request) {

        return Objects.equals(servletContextPath + "/error", request.getURI().getPath());
    }
}
