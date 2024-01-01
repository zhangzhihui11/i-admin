package com.zzh.admin.system.server.controller;

import com.zzh.admin.system.sdk.entity.dto.MenuInsertDTO;
import com.zzh.admin.system.server.entity.MenuDO;
import com.zzh.admin.system.server.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{menuId}")
    public boolean deleteMenu(@PathVariable("menuId") Long menuId) {

        return menuService.deleteMenuItem(menuId);
    }

}
