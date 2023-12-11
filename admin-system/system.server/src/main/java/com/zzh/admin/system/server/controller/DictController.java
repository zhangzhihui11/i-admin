package com.zzh.admin.system.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dict")
public class DictController {

    @GetMapping()
    public String getDict() {
        return Boolean.TRUE.toString();
    }
}
