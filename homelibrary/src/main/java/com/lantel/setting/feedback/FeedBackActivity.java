package com.lantel.setting.feedback;

import com.gyf.immersionbar.BarHide;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseMVPActivity;

import androidx.lifecycle.ViewModel;

public class FeedBackActivity extends BaseMVPActivity {
    @Override
    protected BarHide hideBar() {
        return null;
    }

    @Override
    protected int getStateBarviewID() {
        return 0;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.feedback_content;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }
}
