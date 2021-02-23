package com.loggingmanagementsystem.test.repository;

import com.loggingmanagementsystem.test.model.D_LogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface D_LogInfoRepo extends PagingAndSortingRepository<D_LogInfo, Integer> {

    @Query(value = "select * from d_loginfo T where T.file_name =:fileName", nativeQuery = true)
    Optional<D_LogInfo> getLogInfoByFileName(@Param(value = "fileName") String fileName);

    @Query(value = "select u from D_LogInfo u" )
    Page<D_LogInfo> findAllLogInfo(Pageable pageable);

    @Query(value = "select T.label from d_loginfo_detail T  inner join d_loginfo U  where T.log_id = U.id  and U.file_name = :fileName", nativeQuery = true)
    String getLogInfoContainLabel(@Param(value = "fileName") String fileName);
}
