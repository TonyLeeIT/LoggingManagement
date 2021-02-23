package com.loggingmanagementsystem.test.service;

import com.loggingmanagementsystem.test.model.D_LogInfo;
import com.loggingmanagementsystem.test.model.SearchParm;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface D_LogInfoService {

    Page<D_LogInfo> getLogInfo(SearchParm searchParm);

    Optional<D_LogInfo> findLogInfoByFileName(String fileName);

    void readLogInfo(String fileName) ;

    String findLabel(String fileName);

    void addLogInfo(D_LogInfo logInfo);

    void updateLogInfo(D_LogInfo logInfo);
}
