package com.loggingmanagementsystem.test.repository;

import com.loggingmanagementsystem.test.model.S_ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface S_ErrorCodeRepo extends JpaRepository<S_ErrorCode , String> {
}
