package com.lantel.live.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class LiveCardModel extends BaseModel{
    private String heaImg;
    private String classes_time;
    private String classes_name;
    private int percent;
    private int total;
    private String room_id;
    private String account;

    public String getClasses_time() {
        return classes_time;
    }

    public void setClasses_time(String classes_time) {
        this.classes_time = classes_time;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LiveCardModel() {
    }

    public String getHeaImg() {
        return heaImg;
    }

    public void setHeaImg(String heaImg) {
        this.heaImg = heaImg;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
