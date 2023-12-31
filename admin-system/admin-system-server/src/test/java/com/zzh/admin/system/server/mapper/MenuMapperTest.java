package com.zzh.admin.system.server.mapper;

import com.zzh.admin.system.server.SystemServerApplication;
import com.zzh.admin.system.server.entity.MenuDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {SystemServerApplication.class})
class MenuMapperTest {

    @Resource
    private MenuMapper menuMapper;


    @Test
    void testQueryOne() {
        List<MenuDO> res = menuMapper.selectList(null);
        Assertions.assertTrue(res.isEmpty());
    }
}