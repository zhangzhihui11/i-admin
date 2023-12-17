package com.zzh.admin.system.sdk.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LoginType {
    ACCOUNT_AND_PASSWORD(1, "账号密码"),
    MOBILE_CODE(2, "手机验证码")
    ;

    final Integer code;

    final String desc;
}
