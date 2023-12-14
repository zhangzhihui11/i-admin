package com.zzh.admin.system.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 字典表实体
 */
@Data
@TableName("t_dict")
public class DictDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String dictType;

    private String dictVal;

    private String dictName;

    private String dictAttribute;

    private String dictLink;
}
