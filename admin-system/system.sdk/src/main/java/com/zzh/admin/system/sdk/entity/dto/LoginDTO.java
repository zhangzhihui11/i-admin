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

    @NotBlank(message = "账号不能为空")
    private String userAccount;

    @NotBlank(message = "密码不能为空")
    private String password;
}
