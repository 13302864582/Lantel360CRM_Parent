package com.lantel.setting.personal;

import android.app.Activity;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleEvent;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.personal.mvp.SettingPersonModel;
import com.xiao360.baselibrary.util.LogUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

@Route(path = "/lantel/360/SetPersonal")
public class SettingPersonal extends FragmentActivity {
    private String photoUrl;

    @Override
    protected String getFragmentTag() {
        return Config.SETTING_PERSONAL_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new SettingPersonFragment();
    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    protected void onPhotoSelect(String path){
        photoUrl = path;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(null==data){
            Intent data1 = new Intent();
            if(requestCode == Config.REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK){
                data1.putExtra("photoUrl",photoUrl);
            }
            LogUtils.d("REQUEST_SELECT_PHOTO11=="+photoUrl);
            super.onActivityResult(requestCode, resultCode, data1);
        }else
            super.onActivityResult(requestCode, resultCode,data);
    }
}
