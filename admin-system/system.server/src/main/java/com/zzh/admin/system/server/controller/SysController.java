package com.zzh.admin.system.server.controller;

import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import com.zzh.admin.system.sdk.entity.vo.LoginVO;
import com.zzh.admin.system.server.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SysController {

    private final LoginUserService loginUserService;

    @PostMapping("/login")
    public LoginVO login(@Valid @RequestBody LoginDTO loginDTO) {
        return loginUserService.login(loginDTO);
    }

    @GetMapping("/refreshToken")
    public LoginVO refreshToken(ServletRequest servletRequest) {

        return loginUserService.refreshToken(servletRequest);
    }
}
