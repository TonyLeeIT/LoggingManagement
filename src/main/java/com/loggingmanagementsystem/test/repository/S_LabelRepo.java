package com.loggingmanagementsystem.test.repository;

import com.loggingmanagementsystem.test.model.S_Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface S_LabelRepo extends JpaRepository<S_Label , String> {
}
