package com.zzh.admin.system.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.admin.system.sdk.entity.vo.DictVO;
import com.zzh.admin.system.server.entity.DictDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper extends BaseMapper<DictDO> {

    List<DictVO> getDictByTypes(List<String> dictTypes);

    Long getDictIdByTypeAndVal(@Param("dictType") String dictType, @Param("dictVal") String dictVal);
}
