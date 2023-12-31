package com.zzh.admin.system.server.service.impl;

import com.zzh.admin.system.server.mapper.MenuMapper;
import com.zzh.admin.system.server.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuMapper mapper;
}
