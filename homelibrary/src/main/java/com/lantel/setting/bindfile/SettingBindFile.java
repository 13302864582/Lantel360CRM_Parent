package com.lantel.setting.bindfile;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.fragment.app.Fragment;

/*@Route(path = "/lantel/360/Setting/BindFile")*/
public class SettingBindFile extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.SETTING_BINDFILE_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new BindFileFragment();
    }
}
