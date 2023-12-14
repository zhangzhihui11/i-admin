package com.zzh.admin.system.server.service.impl;

import com.zzh.admin.system.sdk.entity.vo.DictVO;
import com.zzh.admin.system.server.mapper.DictMapper;
import com.zzh.admin.system.server.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DictServiceImpl implements DictService {

    @Resource
    private  DictMapper dictMapper;

    @Override
    public List<DictVO> getDictByType(List<String> dictTypes) {
       return dictMapper.getDictByTypes(dictTypes);
    }
}
