package com.zzh.admin.system.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzh.admin.system.server.entity.MenuDO;

public interface MenuService extends IService<MenuDO> {

    boolean hasChildren(Long menuId);

    boolean deleteMenuItem(Long menuId);
}
