package com.loggingmanagementsystem.test.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_errorcode")
public class S_ErrorCode {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
