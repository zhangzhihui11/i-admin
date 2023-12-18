package com.zzh.admin.common.base.entity;

import lombok.Data;

@Data
public class SimpleUser {

    private Long userId;

    private Long tenantId;

    private String mobile;
}
