package com.zzh.admin.system.server.service.impl;

import com.zzh.admin.system.sdk.entity.vo.DictVO;
import com.zzh.admin.system.server.SystemServerApplication;
import com.zzh.admin.system.server.service.DictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest(classes = {SystemServerApplication.class})
class DictServiceImplTest {

    @Autowired
    private DictService dictService;

    @Test
    void getDictByType() {

        List<DictVO> res = dictService.getDictByType(Collections.singletonList("LOG_TYPE"));
        Assertions.assertTrue(res.isEmpty());
    }
}