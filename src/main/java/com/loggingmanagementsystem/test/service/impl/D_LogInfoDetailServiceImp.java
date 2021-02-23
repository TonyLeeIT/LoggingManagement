package com.loggingmanagementsystem.test.service.impl;

import com.loggingmanagementsystem.test.repository.D_LogInfoDetailRepo;
import com.loggingmanagementsystem.test.service.D_LogInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class D_LogInfoDetailServiceImp implements D_LogInfoDetailService {

    @Autowired
    D_LogInfoDetailRepo d_logInfoDetailRepo;

}
