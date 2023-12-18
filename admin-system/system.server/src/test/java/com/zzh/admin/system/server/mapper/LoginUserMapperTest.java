package com.zzh.admin.system.server.mapper;

import com.zzh.admin.system.server.SystemServerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = {SystemServerApplication.class})
class LoginUserMapperTest {
    @Resource
    private LoginUserMapper loginUserMapper;

    @Test
    void testSelectList() {
        loginUserMapper.selectList(null);
    }

}
