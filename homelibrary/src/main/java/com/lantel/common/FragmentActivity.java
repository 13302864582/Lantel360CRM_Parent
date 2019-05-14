package com.lantel.common;

import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.base.BaseActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class FragmentActivity extends BaseActivity {
    private FragmentManager fragmentManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment;
    }

    @Override
    public void initView() {
        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .init();
        /*Fragment 动态加载*/
        /*创建实例*/
        fragmentManager = getSupportFragmentManager();/*获取到FragmentManager*/
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();/*开启事务*/
        fragmentTransaction.replace(R.id.course_container,getFragment(),getFragmentTag());/*添加fragment，设置tag*/
        fragmentTransaction.commit();/*提交事务*/
    }

    protected abstract String getFragmentTag();

    protected abstract Fragment getFragment();
}
