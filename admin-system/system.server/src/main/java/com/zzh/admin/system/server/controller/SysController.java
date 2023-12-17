package com.zzh.admin.system.server.controller;

import com.zzh.admin.common.base.entity.SimpleUser;
import com.zzh.admin.common.base.utils.JwtUtil;
import com.zzh.admin.system.sdk.entity.dto.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class SysController {

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO loginDTO) {
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setAccount(loginDTO.getPrinciple());
        simpleUser.setUserId(100L);
        return JwtUtil.generateToken(simpleUser);
    }
}
