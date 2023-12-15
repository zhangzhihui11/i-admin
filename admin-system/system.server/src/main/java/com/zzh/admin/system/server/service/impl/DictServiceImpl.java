package com.zzh.admin.system.server.service.impl;

import com.zzh.admin.common.base.exception.AuthException;
import com.zzh.admin.system.sdk.entity.dto.DictDTO;
import com.zzh.admin.system.sdk.entity.vo.DictVO;
import com.zzh.admin.system.server.entity.DictDO;
import com.zzh.admin.system.server.mapper.DictMapper;
import com.zzh.admin.system.server.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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

    @Override
    public boolean isExists(String dictType, String dictVal) {
        return dictMapper.getDictIdByTypeAndVal(dictType, dictVal) != null;
    }

    @Override
    public Boolean insertDict(DictDTO dictDTO) {
        if (isExists(dictDTO.getDictType(), dictDTO.getDictVal())) {
            throw new AuthException(10400,"Dict already exists");
        }
        DictDO entity = new DictDO();
        BeanUtils.copyProperties(dictDTO, entity);
        return dictMapper.insert(entity) > 0;
    }


}
