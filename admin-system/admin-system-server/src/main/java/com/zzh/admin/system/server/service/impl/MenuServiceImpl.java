package com.zzh.admin.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.admin.common.base.exception.BizException;
import com.zzh.admin.system.server.entity.MenuDO;
import com.zzh.admin.system.server.mapper.MenuMapper;
import com.zzh.admin.system.server.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {

    private final MenuMapper mapper;

    @Override
    public boolean hasChildren(Long menuId) {
        return mapper.countChildrenItems(menuId) > 0;
    }

    @Override
    public boolean deleteMenuItem(Long menuId) {
        if (hasChildren(menuId)) {
            throw new BizException(10400, "该目录存在子节点，无法删除");
        }
        return mapper.deleteById(menuId) > 0;
    }
}
