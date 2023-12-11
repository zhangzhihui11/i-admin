package com.zzh.admin.common.base.exception;

import com.zzh.admin.common.base.enums.ExceptionEnum;

public class AuthException extends BizException{

    public AuthException(Integer code, String message) {
        super(code, message);
    }

    public AuthException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
