package com.zzh.admin.system.server.service.impl;

import com.zzh.admin.common.base.entity.SimpleUser;
import com.zzh.admin.common.base.exception.BizException;
import com.zzh.admin.common.base.utils.JwtUtil;
import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import com.zzh.admin.system.sdk.entity.vo.LoginVO;
import com.zzh.admin.system.sdk.enums.LoginType;
import com.zzh.admin.system.server.entity.LoginUserDO;
import com.zzh.admin.system.server.mapper.LoginUserMapper;
import com.zzh.admin.system.server.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserServiceImpl implements LoginUserService {

    private final LoginUserMapper loginUserMapper;

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        LoginType loginType = LoginType.valueOfCode(loginDTO.getLoginType());
        if (loginType == LoginType.ACCOUNT_AND_PASSWORD) {
            String principle = loginDTO.getPrinciple();
            LoginUserDO loginUser;
            if (!principle.contains("@")) {
                loginUser = loginUserMapper.selectByTenantIdAndMobileAndPassword(loginDTO.getTenantId(), principle, loginDTO.getPassword());
            } else {
                loginUser = loginUserMapper.selectByTenantIdAndEmailAndPassword(loginDTO.getTenantId(), principle, loginDTO.getPassword());
            }

            if (loginUser == null) {
                throw new BizException(10500,"用户名或密码错误");
            }
            LoginVO loginVO = new LoginVO();
            BeanUtils.copyProperties(loginUser, loginVO);
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setTenantId(loginUser.getTenantId());
            simpleUser.setUserId(loginUser.getUserId());
            loginVO.setAccessToken(JwtUtil.generateToken(simpleUser));
            loginVO.setRefreshToken(JwtUtil.generateToken(simpleUser, 2*24*60*60L));
            return loginVO;
        }
        return null;
    }
}
