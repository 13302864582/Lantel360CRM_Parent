package com.lantel.homelibrary.homework;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/homework")
public class HomeWorkActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return "";
    }

    @Override
    protected Fragment getFragment() {
        return new HomeWorkFragment();
    }
}
