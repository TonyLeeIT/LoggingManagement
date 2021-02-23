package com.loggingmanagementsystem.test.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "s_label")
public class S_Label {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY , mappedBy ="s_label" ,cascade = CascadeType.ALL)
    private Set<D_LogInfoDetail> d_logInfoDetails;
}
