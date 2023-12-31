package com.zzh.admin.system.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.admin.system.server.entity.MenuDO;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends BaseMapper<MenuDO> {

    /**
     * 统计其子节点数目
     * @param menuId 主键id
     * @return 子节点数
     */
    Integer countChildrenItems(@Param("menuId") Long menuId);
}
