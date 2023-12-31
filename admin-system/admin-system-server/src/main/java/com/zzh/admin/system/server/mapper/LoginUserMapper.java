package com.zzh.admin.system.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.admin.system.server.entity.LoginUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface LoginUserMapper extends BaseMapper<LoginUserDO> {

  LoginUserDO selectByTenantIdAndMobileAndPassword(@Param("tenantId") Long tenantId, @Param("mobile") String mobile, @Param("password") String password);

    LoginUserDO selectByTenantIdAndEmailAndPassword(@Param("tenantId") Long tenantId, @Param("email") String email, @Param("password") String password);
}
