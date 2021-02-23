package com.loggingmanagementsystem.test.service.impl;

import com.loggingmanagementsystem.test.model.D_LogInfo;
import com.loggingmanagementsystem.test.model.SearchParm;
import com.loggingmanagementsystem.test.repository.D_LogInfoRepo;
import com.loggingmanagementsystem.test.service.D_LogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;


@Service
public class D_LogInfoServiceImp implements D_LogInfoService {

    Logger logger = LoggerFactory.getLogger(D_LogInfoServiceImp.class);

    @Autowired
    private D_LogInfoRepo d_logInfoRepo;


    @Override
    public Page<D_LogInfo> getLogInfo(SearchParm searchParm) {
        Pageable pageable = PageRequest.of(searchParm.getPage(), searchParm.getSize(), Sort.by("id").descending());
        return d_logInfoRepo.findAllLogInfo(pageable);
    }

    @Override
    public Optional<D_LogInfo> findLogInfoByFileName(String fileName) {
        return d_logInfoRepo.getLogInfoByFileName(fileName);
    }

    @Transactional
    @Override
    public String findLabel(String fileName) {
        return d_logInfoRepo.getLogInfoContainLabel(fileName);
    }

    @Override
    public void addLogInfo(D_LogInfo logInfo) {
        Optional<D_LogInfo> logInfoOptional = d_logInfoRepo.findById(logInfo.getId());
        if (!logInfoOptional.isPresent()) {
            d_logInfoRepo.save(logInfo);
        } else {
            logger.info("Data existed");
        }
    }

    @Override
    public void updateLogInfo(D_LogInfo logInfo) {
        Optional<D_LogInfo> logInfoOptional = d_logInfoRepo.findById(logInfo.getId());
        if (logInfoOptional.isPresent()) {
            d_logInfoRepo.save(logInfo);
        } else {
            logger.info("Data not exist");
        }
    }

    @Transactional
    @Override
    public void readLogInfo(String fileName) {
        Optional<D_LogInfo> logInfoOptional = findLogInfoByFileName(fileName);
        boolean isExist = logInfoOptional.isPresent();

        D_LogInfo logInfoUpdate;
        if (isExist) {
            logInfoUpdate = logInfoOptional.get();
            logInfoUpdate.setStartLine(logInfoUpdate.getEndLine() + 1);
            System.out.println(logInfoUpdate.getStartLine() + " " + logInfoUpdate.getEndLine());
            int startLine = logInfoUpdate.getStartLine();
            int endLine;
            String label = findLabel(fileName);
            System.out.println(label);
            try {
                String filePath = logInfoUpdate.getFilePath();
                File file = new File(filePath);
                if (!file.exists())
                    System.out.println("no such file");
                int totalLine = (int) Files.lines(Paths.get(filePath)).count();
                int i = startLine - 1;
                while (i < totalLine) {
                    String line = Files.readAllLines(Paths.get(filePath)).get(i);
                    String[] lineArray = line.split(" ");
                    System.out.println(line);

                    boolean check = Arrays.stream(lineArray).anyMatch(item -> item.equals(label));
                    if (check) {
                        System.out.println("insert into database");
                    }
                    i++;
                }
                endLine = i;
                logInfoUpdate.setEndLine(endLine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
