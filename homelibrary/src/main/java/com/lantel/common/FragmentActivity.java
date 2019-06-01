package com.lantel.common;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.base.BaseActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class FragmentActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    protected Fragment mFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment;
    }

    @Override
    public void initView() {
        /*Fragment 动态加载*/
        /*创建实例*/
        fragmentManager = getSupportFragmentManager();/*获取到FragmentManager*/
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();/*开启事务*/
        mFragment = getFragment();
        fragmentTransaction.replace(R.id.course_container,mFragment,getFragmentTag());/*添加fragment，设置tag*/
        fragmentTransaction.commit();/*提交事务*/
    }

    protected abstract String getFragmentTag();

    protected abstract Fragment getFragment();
}
