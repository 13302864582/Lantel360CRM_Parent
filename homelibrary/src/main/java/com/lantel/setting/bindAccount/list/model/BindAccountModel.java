package com.lantel.setting.bindAccount.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class BindAccountModel extends BaseModel {
    private String route_flag;
    private Object image_path;

    public String getRoute_flag() {
        return route_flag;
    }

    public void setRoute_flag(String route_flag) {
        this.route_flag = route_flag;
    }

    public Object getImage_path() {
        return image_path;
    }

    public void setImage_path(Object image_path) {
        this.image_path = image_path;
    }
}
