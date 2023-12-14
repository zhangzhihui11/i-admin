package com.zzh.admin.system.server.service;

import com.zzh.admin.system.sdk.entity.vo.DictVO;

import java.util.List;

public interface DictService  {

    List<DictVO> getDictByType(List<String> dictTypes);
}
