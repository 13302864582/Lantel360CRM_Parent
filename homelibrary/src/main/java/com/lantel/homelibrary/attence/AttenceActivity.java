package com.lantel.homelibrary.attence;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/attence")
public class AttenceActivity extends FragmentActivity {

    @Override
    protected String getFragmentTag() {
        return Config.ATTENCE_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new AttenceFragment();
    }
}
