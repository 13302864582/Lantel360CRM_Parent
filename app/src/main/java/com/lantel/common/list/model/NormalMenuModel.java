package com.lantel.common.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public abstract class NormalMenuModel extends BaseModel {
    private Object imgRes;
    private String Routerpath;

    public Object getImgRes() {
        return imgRes;
    }

    public void setImgRes(Object imgRes) {
        this.imgRes = imgRes;
    }

    public String getRouterpath() {
        return Routerpath;
    }

    public void setRouterpath(String routerpath) {
        Routerpath = routerpath;
    }
}
