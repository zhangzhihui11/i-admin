package com.zzh.admin.system.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_menu")
@Data
public class MenuDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long tenantId;

    private String menuName;

    private String level;

    private String reference;

    private Integer type;

    private Integer order;

    private String creatorId;

    private String createTime;

    private String updateId;

    private String updateTime;

    @TableLogic
    private Integer deleted;
}
