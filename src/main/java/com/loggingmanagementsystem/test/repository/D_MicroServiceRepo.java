package com.loggingmanagementsystem.test.repository;

import com.loggingmanagementsystem.test.model.D_MicroService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface D_MicroServiceRepo extends JpaRepository<D_MicroService , String> {
}
