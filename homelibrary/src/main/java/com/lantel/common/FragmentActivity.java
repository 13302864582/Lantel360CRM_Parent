package com.lantel.common;

import android.content.Intent;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.base.BaseActivity;

import androidx.annotation.Nullable;
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
        /*Fragment 动态加载*/
        /*创建实例*/
        fragmentManager = getSupportFragmentManager();/*获取到FragmentManager*/
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();/*开启事务*/
        fragmentTransaction.replace(R.id.course_container,getFragment(),getFragmentTag());/*添加fragment，设置tag*/
        fragmentTransaction.commit();/*提交事务*/
    }

    protected abstract String getFragmentTag();

    protected abstract Fragment getFragment();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        getFragment().onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
