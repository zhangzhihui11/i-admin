package com.zzh.admin.common.base.support;

import com.zzh.admin.common.base.enums.RespStatus;
import com.zzh.admin.common.base.response.Resp;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Resp<Object> handleException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        e.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append(";"));
        return Resp.buildResp(RespStatus.INVALID_INPUT.getCode(), errorMessage.toString(), null);
    }
}
