package com.zzh.admin.system.sdk.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long pid;

    private String menuName;

    private String level;

    private String reference;

    private Integer type;

    private Integer menuOrder;
}
