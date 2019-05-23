package com.lantel.homelibrary.accessment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/assessment")
public class AccessMentActivity extends FragmentActivity {

    @Override
    protected String getFragmentTag() {
        return Config.ACCESSMENT_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new AccessMentFragment();
    }
}
