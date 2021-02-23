package com.loggingmanagementsystem.test.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "d_loginfo")
@AllArgsConstructor
@NoArgsConstructor
public class D_LogInfo {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_name" , nullable = false)
    private D_MicroService d_microService;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "reading_dt")
    private Date readingDt;

    @Column(name = "start_line")
    private int startLine;

    @Column(name = "end_line")
    private int endLine;

    @Column(name = "is_lastest_record")
    private String isLastestRecord;

    @OneToMany(fetch = FetchType.LAZY , mappedBy ="d_logInfo" ,cascade = CascadeType.ALL)
    private Set<D_LogInfoDetail> d_logInfoDetails;


    public D_LogInfo(Integer id, String fileName, String filePath, int startLine, int endLine, String isLastestRecord) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.startLine = startLine;
        this.endLine = endLine;
        this.isLastestRecord = isLastestRecord;
    }

    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getReadingDt() {
        return readingDt;
    }

    public void setReadingDt(Date readingDt) {
        this.readingDt = readingDt;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }


}
