package com.zzh.admin.system.server.controller;

import com.zzh.admin.common.base.annotations.Log;
import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import com.zzh.admin.system.sdk.entity.vo.LoginVO;
import com.zzh.admin.system.server.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@Log
public class SysController {

    private final LoginUserService loginUserService;

    @PostMapping("/login")
    public LoginVO login(@RequestBody @Valid LoginDTO loginDTO) {
        return loginUserService.login(loginDTO);
    }

    @GetMapping("/refreshToken")
    public LoginVO refreshToken(ServletRequest servletRequest) {

        return loginUserService.refreshToken(servletRequest);
    }

    @GetMapping("/one")
    public String testValidate(@RequestParam  String userId) {

        return userId;
    }
}
