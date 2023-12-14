package com.zzh.admin.system.server.controller;

import com.zzh.admin.system.sdk.entity.vo.DictVO;
import com.zzh.admin.system.server.mapper.DictMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict")
public class DictController {

    private final DictMapper dictMapper;

    @GetMapping()
    public List<DictVO> getDict(@RequestParam List<String> dictTypes) {
        return dictMapper.getDictByTypes(dictTypes);
    }
}
