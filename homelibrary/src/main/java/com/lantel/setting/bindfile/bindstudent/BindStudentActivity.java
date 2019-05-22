package com.lantel.setting.bindfile.bindstudent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/Setting/BindFile")
public class BindStudentActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.BIND_STUDENT_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new BindStudentFragment();
    }
}
