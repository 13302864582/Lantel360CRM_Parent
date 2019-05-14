package com.lantel.homelibrary.course;

import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import androidx.fragment.app.Fragment;

public class CourseActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.COURSE_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new CourseFragment();
    }
}
