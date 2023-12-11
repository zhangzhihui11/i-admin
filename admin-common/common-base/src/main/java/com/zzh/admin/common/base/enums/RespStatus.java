package com.zzh.admin.common.base.enums;

import lombok.Getter;

@Getter
public enum RespStatus {

    SUCCESS(10200, "Success"),
    FAILED(10400, "Failed"),
    INVALID_INPUT(10500, "非法入参"),
    ;

    private final Integer code;

    private final String message;

    RespStatus(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

}
