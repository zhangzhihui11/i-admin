package com.zzh.admin.system.sdk.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public enum LoginType {
    ACCOUNT_AND_PASSWORD(1, "账号密码"),
    MOBILE_CODE(2, "手机验证码")
    ;

    final Integer code;

    final String desc;

    public static LoginType valueOfCode(Integer code) {

        LoginType[] values = LoginType.values();
        for (LoginType value : values) {
            if (Objects.equals(value.getCode(), code)) {

                return value;
            }
        }
        return null;
    }
}
