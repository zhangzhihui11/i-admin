package com.zzh.admin.system.server.service;

import com.zzh.admin.system.sdk.entity.dto.DictDTO;
import com.zzh.admin.system.sdk.entity.vo.DictVO;

import java.util.List;

public interface DictService  {

    List<DictVO> getDictByType(List<String> types);

    boolean isExists(String dictType, String dictVal);

    Boolean insertDict(DictDTO dictDTO);
}
