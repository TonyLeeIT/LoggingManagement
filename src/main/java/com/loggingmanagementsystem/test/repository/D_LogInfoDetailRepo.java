package com.loggingmanagementsystem.test.repository;

import com.loggingmanagementsystem.test.model.D_LogInfo;
import com.loggingmanagementsystem.test.model.D_LogInfoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface D_LogInfoDetailRepo extends JpaRepository<D_LogInfoDetail, Integer> {


    @Query(value = "select U.* from d_loginfo_detail T inner join d_loginfo U where T.log_id = U.id and T.log_id = :logId", nativeQuery = true)
    Optional<D_LogInfo> getLogInfoById(@Param(value = "logId") Integer logId);
}
