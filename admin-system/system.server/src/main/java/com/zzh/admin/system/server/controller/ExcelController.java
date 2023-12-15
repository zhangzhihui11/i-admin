package com.zzh.admin.system.server.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.zzh.admin.system.server.entity.ExcelUser;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @GetMapping("user")
    public ResponseEntity<byte[]> exportUser() throws IOException {
        File file = new File("one.xlsx");
        EasyExcelFactory.write(file, ExcelUser.class).sheet().doWrite(Arrays.asList(new ExcelUser("root","root@qq.com"), new ExcelUser("admin", "admin@sina.com")));
        byte[] bytes = FileCopyUtils.copyToByteArray(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + "user.xlsx");
        FileUtils.delete(file);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .contentType(MediaType.valueOf(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .body(bytes);
    }
}
