package com.lantel.setting.personal.mvp;

import androidx.lifecycle.ViewModel;

public class SettingPersonModel extends ViewModel {
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
