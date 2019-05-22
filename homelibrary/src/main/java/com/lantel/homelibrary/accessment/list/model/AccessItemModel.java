package com.lantel.homelibrary.accessment.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class AccessItemModel extends BaseModel{
    private String date;
    private String time;
    private String className;
    private int state;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public long getTimeLong() {
        if(time.indexOf(0)==0){
            time.replaceAll("^(0+)", "").trim();
        }
        return Long.valueOf(time);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
