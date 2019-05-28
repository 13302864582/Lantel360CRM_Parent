package com.lantel.homelibrary.attence.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class AttenceCardModel extends BaseModel implements Comparable<AttenceCardModel>{
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
        String timelong = time;
        if(timelong.indexOf(0)==0){
            timelong.replaceAll("^(0+)", "").trim();
        }
        return Long.valueOf(timelong);
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

    @Override
    public int compareTo(AttenceCardModel attenceModel) {
        long i = Long.valueOf(this.getDate()) - Long.valueOf(attenceModel.getDate());
        if(i == 0){
            i = getTimeLong() - attenceModel.getTimeLong();
        }
        if(i == 0)
            return 0;
        if(i>0)
            return 1;
        else
            return -1;
    }
}
