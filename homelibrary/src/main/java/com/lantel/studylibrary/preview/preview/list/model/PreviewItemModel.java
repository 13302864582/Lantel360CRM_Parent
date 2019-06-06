package com.lantel.studylibrary.preview.preview.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class PreviewItemModel extends BaseModel {
    private String time;
    private String date;
    private String room;
    private String content;
    private String ca_id;

    public String getCa_id() {
        return ca_id;
    }

    public void setCa_id(String ca_id) {
        this.ca_id = ca_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
