package com.zzh.admin.system.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzh.admin.common.base.constants.RequestHeader;
import com.zzh.admin.common.base.entity.SimpleUser;
import com.zzh.admin.common.base.exception.BizException;
import com.zzh.admin.common.base.utils.JwtUtil;
import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import com.zzh.admin.system.sdk.entity.vo.LoginVO;
import com.zzh.admin.system.sdk.enums.LoginType;
import com.zzh.admin.system.sdk.enums.LoginUserStatus;
import com.zzh.admin.system.server.entity.LoginUserDO;
import com.zzh.admin.system.server.mapper.LoginUserMapper;
import com.zzh.admin.system.server.service.LoginUserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

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
            return buildLoginVO(loginUser);
        }
        return null;
    }

    @Override
    public LoginVO refreshToken(ServletRequest request) {
        HttpServletRequest newRequest = (HttpServletRequest) request;
        String refreshToken = newRequest.getHeader(RequestHeader.REFRESH_TOKEN_KEY);
        if (StringUtils.isBlank(refreshToken)) {
            throw new BizException(10500, "Refresh Token为空");
        }
        Claims claims = JwtUtil.parseToken(refreshToken);
        Long userId = claims.get("userId", Long.class);
        Long tenantId = claims.get("tenantId", Long.class);
        if (tenantId == null || userId == null) {
            throw new BizException(10500, "Refresh Token不合法");
        }
        QueryWrapper<LoginUserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("tenant_id", tenantId);
        queryWrapper.eq("status", LoginUserStatus.ACTIVE.getCode());
        LoginUserDO loginUser = loginUserMapper.selectOne(queryWrapper);
        if (loginUser == null) {
            throw new BizException(10500, "Refresh Token不合法");
        }
       return buildLoginVO(loginUser);
    }

    private LoginVO buildLoginVO(LoginUserDO loginUser) {
        LoginVO loginVO = new LoginVO();
        BeanUtils.copyProperties(loginUser, loginVO);
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setTenantId(loginUser.getTenantId());
        simpleUser.setUserId(loginUser.getUserId());
        loginVO.setAccessToken(JwtUtil.generateToken(simpleUser));
        loginVO.setRefreshToken(JwtUtil.generateToken(simpleUser, 24*60*60L));
        return loginVO;
    }
}
