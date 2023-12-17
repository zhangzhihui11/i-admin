package com.zzh.admin.system.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_login_user")
@Data
public class LoginUserDO {

    private Long id;

    private Long userId;

    private Long tenantId;

    private String mobile;

    private String email;

    private String password;

    private String avatar;

    private Integer status;

    private boolean deleted;

}
