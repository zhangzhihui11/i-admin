package com.zzh.admin.system.server.controller;

import com.zzh.admin.system.sdk.entity.dto.DictDTO;
import com.zzh.admin.system.sdk.entity.vo.DictVO;
import com.zzh.admin.system.server.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict")
@Api
public class DictController {

    private final DictService dictService;

    @GetMapping()
    @ApiOperation(value = "hello")
    public List<DictVO> getDict(@RequestParam List<String> types) {
        return dictService.getDictByType(types);
    }

    @PostMapping
    @ApiOperation(value = "world")
    public Boolean insertDict(@RequestBody @Valid DictDTO dictDTO) {
        return dictService.insertDict(dictDTO);
    }
}
