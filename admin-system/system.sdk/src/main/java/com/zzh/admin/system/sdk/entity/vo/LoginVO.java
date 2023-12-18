package com.zzh.admin.system.sdk.entity.vo;

import lombok.Data;

@Data
public class LoginVO {

    private Long userId;

    private Long tenantId;

    private String accessToken;

    private String refreshToken;
}
