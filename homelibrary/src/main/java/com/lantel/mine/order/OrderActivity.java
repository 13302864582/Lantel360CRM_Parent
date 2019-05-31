package com.lantel.mine.order;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/order")
public class OrderActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return "";
    }

    @Override
    protected Fragment getFragment() {
        return new OrderFragment();
    }
}
