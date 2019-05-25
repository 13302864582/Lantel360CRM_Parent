package com.lantel.studylibrary.classes;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/class")
public class ClassesActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.CLASSES_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new ClassesFragment();
    }
}
