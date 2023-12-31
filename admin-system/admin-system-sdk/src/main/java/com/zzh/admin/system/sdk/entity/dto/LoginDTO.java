package com.zzh.admin.system.sdk.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登陆实体
 */
@Data
public class LoginDTO {

    @NotNull(message = "登录方式不能为空")
    private Integer loginType;

    @NotNull(message = "租户id不能为空")
    private Long tenantId;

    @NotBlank(message = "账号不能为空")
    private String principle;

    private String password;

    private String smsCode;

    private String checkCode;

}
