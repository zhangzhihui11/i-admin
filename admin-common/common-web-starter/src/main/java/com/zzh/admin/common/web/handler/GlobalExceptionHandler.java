package com.zzh.admin.common.web.handler;

import com.zzh.admin.common.base.enums.RespStatus;
import com.zzh.admin.common.base.exception.BizException;
import com.zzh.admin.common.base.response.Resp;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resp<Object> handleException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            return handleMethodArgumentNotValidException((MethodArgumentNotValidException) e);
        }
        if (e instanceof BizException) {
            return handleBizException((BizException) e);
        }
        return Resp.buildResp(10500, e.getMessage(), null);
    }

    public Resp<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        e.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append(";"));
        return Resp.buildResp(RespStatus.INVALID_INPUT.getCode(), errorMessage.toString(), null);
    }

    public Resp<Object> handleBizException(BizException e) {

        return Resp.buildResp(e.getCode(), e.getMessage(), null);
    }
}
