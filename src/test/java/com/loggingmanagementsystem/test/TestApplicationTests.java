package com.loggingmanagementsystem.test;

import com.loggingmanagementsystem.test.model.D_LogInfo;
import com.loggingmanagementsystem.test.model.SearchParm;
import com.loggingmanagementsystem.test.repository.D_LogInfoRepo;
import com.loggingmanagementsystem.test.service.impl.D_LogInfoDetailServiceImp;
import com.loggingmanagementsystem.test.service.impl.D_LogInfoServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    D_LogInfoServiceImp d;

    @Test
    void contextLoads() {
        D_LogInfo logInfo = new D_LogInfo(1 , "catalina.2021-01-14.log" , "H:\\loggingmanagement\\logFIle\\catalina.2021-01-14.log", 1,20 , "1");
//        d.readLogInfo("catalina.2021-01-14.log");
//        d.addLogInfo(logInfo);

        SearchParm searchParm = new SearchParm(0 , 10);
        d.getLogInfo(searchParm);
    }

}
