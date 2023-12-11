package com.zzh.admin.common.base.response;

import com.zzh.admin.common.base.enums.RespStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
