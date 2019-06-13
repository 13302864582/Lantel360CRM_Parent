package com.lantel.setting.editPassword;

import java.util.List;

public class ChangPwdBean {

    /**
     * error : 0
     * message : success
     * data : []
     * authed : true
     */

    private int error;
    private String message;
    private boolean authed;
    private List<?> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
