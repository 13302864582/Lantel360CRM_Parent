package com.lantel.studylibrary.preview.preview.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class AttachFile extends BaseModel {
    private String file_url;
    private int file_size;
    private String file_type;

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }
}
