package com.lantel.homelibrary.classreview;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/classreview")
public class ClassReviewActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.CLASSREVIEW_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new ClassReviewFragment();
    }
}
