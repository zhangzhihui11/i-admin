package com.zzh.admin.common.base.support;

import com.zzh.admin.common.base.response.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resp<Object> handleException(Exception e) {

        return Resp.failed(e.getMessage());
    }
}
