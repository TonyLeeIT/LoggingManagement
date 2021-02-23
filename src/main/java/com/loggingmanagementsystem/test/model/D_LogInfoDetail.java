package com.loggingmanagementsystem.test.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "d_loginfo_detail")
public class D_LogInfoDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_id", nullable = false)
    private D_LogInfo d_logInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label", nullable = false)
    private S_Label s_label;

    @Column(name = "reading_dt")
    private Date readingDt;

    @Column(name = "content")
    private String content;


}
