package com.loggingmanagementsystem.test.model;

import lombok.Data;

@Data
public class SearchParm {

    private String param01;
    private String param02;
    private String param03;
    private String param04;

    private int page;
    private int size;

    public SearchParm(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
