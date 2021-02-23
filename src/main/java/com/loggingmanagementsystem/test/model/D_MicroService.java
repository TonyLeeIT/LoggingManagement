package com.loggingmanagementsystem.test.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "d_microservice")
public class D_MicroService {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "directory")
    private String directory;

    @Column(name = "format_file_name")
    private String formatFileName;

    @Column(name = "format_file_type")
    private String formatFileType;

    @Column(name = "record_status")
    private String recordStatus;

    @Column(name = "created_dt")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;

    @Column(name = "updated_dt")
    @LastModifiedDate
    private Date updatedDt;

    @OneToMany(fetch = FetchType.LAZY , mappedBy ="d_microService" ,cascade = CascadeType.ALL)
    private Set<D_LogInfo> d_logInfos;
}
