package com.lantel.common;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.xiao360.baselibrary.base.BaseActivity;
import butterknife.BindView;

@Route(path = "/lantel/360/credit")
public class WebActivity extends BaseActivity {
    @BindView(R2.id.webview)
    X5WebView webview;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.web;
    }

    @Override
    public void initView() {
        webview.loadUrl("http://dev.xiao360.com/student#/recommend");
    }
}
