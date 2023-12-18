package com.zzh.admin.system.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户登录表实体
 */
@TableName("t_login_user")
@Data
public class LoginUserDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long tenantId;

    private String mobile;

    private String email;

    private String password;

    private String avatar;

    private Integer status;

    @TableLogic
    private boolean deleted;

}
