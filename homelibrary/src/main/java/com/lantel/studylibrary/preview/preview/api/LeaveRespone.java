package com.lantel.studylibrary.preview.preview.api;

import com.lantel.common.HttpResBean;

import java.util.List;

public class LeaveRespone extends HttpResBean {

    /**
     * error : 0
     * message : success
     * data : []
     * authed : true
     */
    private boolean authed;
    private List<?> data;



    public boolean isAuthed() {
        return authed;
    }

    public void setAuthed(boolean authed) {
        this.authed = authed;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
