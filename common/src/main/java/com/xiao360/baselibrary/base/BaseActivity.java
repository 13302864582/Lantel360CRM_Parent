package com.xiao360.baselibrary.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cangwang.core.ModuleBus;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.xiao360.baselibrary.util.AppManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends RxAppCompatActivity {
    private Context mContext;
    private boolean isConfigChange = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doBeforeSetcontentView();

        //设置视图布局
        setContentView(getLayoutId());

        //ButterKnife绑定注入
        ButterKnife.bind(this);

        if(getStateBarviewID()!=-1)
            findViewById(getStateBarviewID()).setVisibility(Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT? View.GONE:View.VISIBLE);


        //模块路由绑定注入
        ARouter.getInstance().inject(this);

        //模块通信绑定
        ModuleBus.getInstance().register(this);

        mContext = this;
        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .init();
        this.initView();
    }

    protected abstract int getStateBarviewID();


    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //初始化view
    public abstract void initView();

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ModuleBus.getInstance().unregister(this);
        if (!isConfigChange) {
            AppManager.getAppManager().finishActivity(this);
        }
    }
}
