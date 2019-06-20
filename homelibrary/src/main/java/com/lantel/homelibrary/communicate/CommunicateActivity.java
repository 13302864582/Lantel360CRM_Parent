package com.lantel.homelibrary.communicate;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/communicate")
public class CommunicateActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.OUTPUT_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new CommunicateFragment();
    }
}
