package com.loggingmanagementsystem.test.controller;

import com.loggingmanagementsystem.test.model.D_LogInfo;
import com.loggingmanagementsystem.test.model.SearchParm;
import com.loggingmanagementsystem.test.service.D_LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class D_LogInfoController {

    @Autowired
    D_LogInfoService logInfoService;

    @PutMapping("/api/v1/lgm/log/getLogFileInfo")
    public ResponseEntity<Page<D_LogInfo>> getAll(@RequestBody SearchParm searchParm){
        return ResponseEntity.ok(logInfoService.getLogInfo(searchParm));
    }


}
