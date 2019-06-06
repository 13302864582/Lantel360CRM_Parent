package com.lantel.homelibrary.output.list.model;

import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;

public class CardOutputModel extends BaseModel{
    private String headImg;
    private String name;
    private String content;
    private ArrayList<BaseModel> imgs;
    private ArrayList<BaseModel> files;
    private String classes;
    private String adress;
    private boolean isSupport;

    public ArrayList<BaseModel> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<BaseModel> files) {
        this.files = files;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<BaseModel> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<BaseModel> imgs) {
        this.imgs = imgs;
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
