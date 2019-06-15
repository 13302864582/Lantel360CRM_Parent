package com.lantel.setting.personal;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/SetPersonal")
public class SettingPersonal extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.SETTING_PERSONAL_TAG;
    }

    @Override
    protected Fragment getFragment() {
        SettingPersonFragment fragment = new SettingPersonFragment();
        return fragment;
    }
}
