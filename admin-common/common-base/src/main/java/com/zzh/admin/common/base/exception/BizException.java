package com.zzh.admin.common.base.exception;

import com.zzh.admin.common.base.enums.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizException extends RuntimeException{

    private  final Integer code;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
