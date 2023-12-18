package com.zzh.admin.system.server.mapper;

import com.zzh.admin.system.server.SystemServerApplication;
import com.zzh.admin.system.server.entity.LoginUserDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = {SystemServerApplication.class})
class LoginUserMapperTest {
    @Resource
    private LoginUserMapper loginUserMapper;

    @Test
    void testSelectList() {
        List<LoginUserDO> res = loginUserMapper.selectList(null);
        Assertions.assertFalse(res.isEmpty());
    }

    @Test
    void testMobileLogin() {
        LoginUserDO root = loginUserMapper.selectByTenantIdAndMobileAndPassword(0L, "13569599648", "root");
        Assertions.assertNotNull(root);
    }

}
