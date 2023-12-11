package com.zzh.admin.common.base.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    INVALID_TOKEN(10401, "无效的token"),
    EXPIRED_TOKEN(10401, "token已过期")
    ;
    private final Integer code;

    private final String message;


    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
