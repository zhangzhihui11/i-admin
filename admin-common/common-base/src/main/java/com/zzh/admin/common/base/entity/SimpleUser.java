package com.zzh.admin.common.base.entity;

import lombok.Data;

@Data
public class SimpleUser {

    private Long userId;

    private String account;

    private String nickname;

    private String email;

    private String mobile;

    private String avatar;

    private Integer status;
}
