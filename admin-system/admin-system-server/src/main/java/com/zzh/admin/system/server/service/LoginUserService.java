package com.zzh.admin.system.server.service;

import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import com.zzh.admin.system.sdk.entity.vo.LoginVO;

import javax.servlet.ServletRequest;

public interface LoginUserService {

    LoginVO login(LoginDTO loginDTO);

    LoginVO refreshToken(ServletRequest request);
}
