package com.zzh.admin.system.sdk.entity.dto;

import lombok.Data;

@Data
public class MenuInsertDTO {

    private Long tenantId;

    private String menuName;

    private String level;

    private String reference;

    private Integer type;

    private Integer order;
}
