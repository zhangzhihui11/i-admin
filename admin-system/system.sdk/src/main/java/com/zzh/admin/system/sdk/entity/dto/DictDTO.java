package com.zzh.admin.system.sdk.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DictDTO {

    @NotBlank(message = "字典类型不能为空")
    private String dictType;

    @NotBlank(message = "字典枚举值不能为空")
    private String dictVal;

    @NotBlank(message = "字典枚举名称不能为空")
    private  String dictName;

    private String dictLink;

    private String dictAttribute;
}
