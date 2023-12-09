package com.zzh.admin.system.sdk.feign.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient
public interface SystemUserService {

    @GetMapping("/system/user/{userId}")
    void getSystemUser(@PathVariable("userId") Long userId);
}
