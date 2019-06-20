package com.lantel.homelibrary;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.X5WebView;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.util.ToastUitl;

import butterknife.BindView;

@Route(path = "/lantel/360/web")
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
        String url = getIntent().getStringExtra(Config.WEB_URL);
        if(null != url)
        webview.loadUrl(url);
        else{
            ToastUitl.showShort(R.string.null_url);
            finish();
        }
    }
}
