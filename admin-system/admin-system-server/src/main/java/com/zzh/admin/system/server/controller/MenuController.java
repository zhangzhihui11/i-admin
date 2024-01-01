package com.zzh.admin.system.server.controller;

import com.zzh.admin.system.sdk.entity.dto.MenuInsertDTO;
import com.zzh.admin.system.server.entity.MenuDO;
import com.zzh.admin.system.server.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public boolean insertMenu(MenuInsertDTO insertDTO) {
        MenuDO menuEntity = new MenuDO();
        BeanUtils.copyProperties(insertDTO, menuEntity);
        return menuService.save(menuEntity);
    }

}
