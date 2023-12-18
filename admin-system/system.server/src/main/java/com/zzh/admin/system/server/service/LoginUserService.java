package com.zzh.admin.system.server.service;

import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import com.zzh.admin.system.sdk.entity.vo.LoginVO;

public interface LoginUserService {

    LoginVO login(LoginDTO loginDTO);
}
