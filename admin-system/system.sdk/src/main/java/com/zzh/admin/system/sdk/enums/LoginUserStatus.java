package com.zzh.admin.system.sdk.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LoginUserStatus {
    ACTIVE(1, "active"),
    FROZEN(2, "frozen"),
    ;

    final Integer code;

    final String describe;
}
