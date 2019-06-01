package com.lantel.app;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;
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
 * */

@Route(path = "/lantelhome/360/app")
public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private NavController mNavController;
    private NavHostFragment navHost;
    private int mLastNavId = -1;
    private boolean updateCard = false;

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
        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setOnNavigationItemSelectedListener(mPresenter);

        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController = navHost.getNavController();
        navigate(R.id.action_mine);
        bottomNavigation.setSelectedItemId(R.id.item_mine);

        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .init();
    }

    @Override
    public void navigate(int action_id) {
        if(action_id == mLastNavId)
            return;
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
          updateCard = false;
          ModuleBus.getInstance().post(IBaseClient.class,"refreshCard","");
      }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Config.REQUEST_CHANGE_ACCOUNT && resultCode == Activity.RESULT_OK){
            updateCard = true;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
