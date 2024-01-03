package com.zzh.admin.system.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_role")
public class Role {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String tenantId;

    private String roleName;

    private Long createBy;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    @TableLogic
    private boolean deleted;
}
