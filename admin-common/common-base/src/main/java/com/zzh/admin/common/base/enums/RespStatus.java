package com.zzh.admin.common.base.enums;

public enum RespStatus {

    SUCCESS(10200, "Success"),
    FAILED(10400, "Failed"),
    ;

    private final Integer code;

    private final String message;

    RespStatus(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
