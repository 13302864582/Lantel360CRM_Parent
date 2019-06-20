package com.lantel.homelibrary.homework.api;

public class UpLoadAttach {
    private String file_name;
    private String file_url;
    private String file_type;
    private long file_size;
    private int js_upload;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public int getJs_upload() {
        return js_upload;
    }

    public void setJs_upload(int js_upload) {
        this.js_upload = js_upload;
    }
}
