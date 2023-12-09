package com.zzh.admin.common.base.response;

import com.zzh.admin.common.base.enums.RespStatus;

public class Resp<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T>Resp<T> success() {

        return success(null);
    }

    public static <T>Resp<T> success(T data) {

        return buildResp(RespStatus.SUCCESS.getCode(), RespStatus.SUCCESS.getMessage(), data);
    }

    public static <T>Resp<T> failed() {

        return failed(null);
    }

    public static <T>Resp<T> failed(T data) {

        return buildResp(RespStatus.FAILED.getCode(), RespStatus.FAILED.getMessage(), data);
    }

    public static <T>Resp<T> buildResp(Integer code, String message, T data) {

        return new Resp<>(code, message, data);
    }


    public Resp(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
