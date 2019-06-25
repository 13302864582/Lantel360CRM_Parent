package com.lantel.app;

import android.app.Activity;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.immersionbar.BarHide;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;
import com.lantel.common.HomeClient;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseMVPActivity;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;

/**
 * app启动activity
 * 导航界面容器
 * */

@Route(path = "/lantelhome/360/app")
public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private NavController mNavController;
    private NavHostFragment navHost;
    private int mLastNavId = -1;
    private boolean updateCard = false;
    private boolean updateHome = false;

    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
    }

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    protected AppModel getModel() {
        return FindModel(AppModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.app;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        //底部导航初始化设置监听
        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setOnNavigationItemSelectedListener(mPresenter);

        //fragment导航控件初始化
        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController = navHost.getNavController();

        //默认显示我的页面
        navigate(R.id.action_home);
        bottomNavigation.setSelectedItemId(R.id.item_home);
    }

    @Override
    public void navigate(int action_id) {
        //如果是本页，不处理
        if(action_id == mLastNavId)
            return;

        //如果不是本页，跳转，设置切换渐变动画效果
        mLastNavId = action_id;
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        NavOptions options = builder.build();
        mNavController.navigate(action_id,null,options);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }

    @Override
    protected void onResume() {
        super.onResume();
      if(updateCard){
          //事件通知我的页面更新
          updateCard = false;
          ModuleBus.getInstance().post(IBaseClient.class,"refreshCard","");
      }

        if(updateHome){
            //事件通知主页页面更新
            updateHome = false;
            ModuleBus.getInstance().post(HomeClient.class,"refreshHomeTop","");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //从我的切换档案后返回更新
        if(requestCode == Config.REQUEST_CHANGE_ACCOUNT && resultCode == Activity.RESULT_OK){
            updateCard = true;
        }

        //从主页切换档案后返回更新
        if(requestCode == Config.REQUEST_CHANGE_BID && resultCode == Activity.RESULT_OK){
            updateHome = true;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
