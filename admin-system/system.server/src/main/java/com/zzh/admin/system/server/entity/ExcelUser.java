package com.zzh.admin.system.server.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExcelUser {

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("邮箱")
    private String email;
}
