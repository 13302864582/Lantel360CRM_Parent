package com.lantel.homelibrary.output.list.model;

import com.lantel.common.list.model.MediaModel;
import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;
import java.util.Map;

public class CardOutputModel extends BaseModel{
    private String headImg;
    private String content;
    private String time;
    private Map<String,ArrayList<MediaModel>> map;
    private String classes;
    private String adress;
    private boolean isSupport;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Map<String, ArrayList<MediaModel>> getMap() {
        return map;
    }

    public void setMap(Map<String, ArrayList<MediaModel>> map) {
        this.map = map;
    }

    public boolean isSupport() {
        return isSupport;
    }

    public void setSupport(boolean support) {
        isSupport = support;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
