package com.lantel.studylibrary.classes;

import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import androidx.fragment.app.Fragment;

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
