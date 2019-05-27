package com.lantel.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.AppConfig;
import com.lantel.common.GlideImageLoader;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.home.list.adpter.HomeMenuListApater;
import com.lantel.home.mvp.HomeContract;
import com.lantel.home.mvp.HomeModel;
import com.lantel.home.mvp.HomePresenter;
import com.xiao360.baselibrary.base.BaseMVPFragment;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;
import com.xiao360.baselibrary.util.LogUtils;
import com.youth.banner.Banner;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;
import java.util.ArrayList;
import java.util.List;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseMVPFragment<HomePresenter, HomeModel> implements HomeContract.View, OnActionPathListener {
    @BindView(R.id.statebarView)
    View statebarView;
    @BindView(R.id.top_img_left_user)
    ImageView topImgLeftUser;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.arrow_user)
    ImageView arrow_user;
    @BindView(R.id.top_img_right_redpoint)
    ImageView topImgRightRedpoint;
    @BindView(R.id.top_img_right_notify)
    ImageView topImgRightNotify;
    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.top_img_right_scan)
    ImageView topImgRightScan;
    @BindView(R.id.toolbar)
    ConstraintLayout toolbar;
    @BindView(R.id.organ)
    TextView organ;
    @BindView(R.id.phone_text)
    TextView phoneText;
    @BindView(R.id.location_text)
    TextView locationText;
    @BindView(R.id.school_area)
    TextView schoolArea;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.home_menu_list)
    RecyclerView homeMenuList;
    @BindView(R.id.banner)
    Banner banner;

    private HomeMenuListApater mHomeMenuAdapter;

    @Override
    public void notifyMenuData(ArrayList<SimpleMenuModel> list) {

    }

    @Override
    public void loadCircleHeadImage(String url) {

    }

    @Override
    public void initMenuData(ArrayList<SimpleMenuModel> menu) {
        homeMenuList.setLayoutManager(new GridLayoutManager(getContext(),4));
        mHomeMenuAdapter = new HomeMenuListApater(getContext(),menu);
        mHomeMenuAdapter.setListener(this);
        homeMenuList.setAdapter(mHomeMenuAdapter);
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected HomeModel getModel() {
        return FindModel(HomeModel.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.moudle_home;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mPresenter.initMenu();
        initBanner();
    }

    private void initBanner() {
        banner.setImageLoader(new GlideImageLoader(R.mipmap.ad));
        //设置图片集合
        List list = new ArrayList<String>();
        list.add("fz");
        banner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void navigationPath(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    @OnClick({R.id.top_img_left_user, R.id.username, R.id.arrow_user, R.id.top_img_right_notify, R.id.top_img_right_scan, R.id.phone_img, R.id.phone_text, R.id.home_arrow_ad, R.id.banner,R.id.home_more_ad})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.top_img_right_notify){
            LogUtils.d("onViewClicked===notify");
        }
        else if(id == R.id.top_img_right_scan){
            LogUtils.d("onViewClicked===scan");
            navigateScan();
        }
        else if(id == R.id.home_arrow_ad || id == R.id.banner || id == R.id.home_more_ad){
            LogUtils.d("onViewClicked===ad");
        }
        else if(id == R.id.phone_img || id == R.id.phone_text){
            LogUtils.d("onViewClicked===phone");
        }
        else if(id == R.id.top_img_left_user || id == R.id.username || id == R.id.arrow_user){
            LogUtils.d("onViewClicked===user");
        }
    }

    public void navigateScan() {
        /**
         * 点击扫描按钮，进入扫一扫二级页面
         *ZxingConfig是配置类
         *可以设置是否显示底部布局，闪光灯，相册，
         * 是否播放提示音  震动
         * 设置扫描框颜色等
         * 也可以不传这个参数
         **/

        ZxingConfig config = new ZxingConfig();
        config.setPlayBeep(true);//是否播放扫描声音 默认为true
        config.setShake(false);//是否震动  默认为true
        config.setDecodeBarCode(true);//是否扫描条形码 默认为true
        config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
        config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
        config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色*//*
        config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
        startActivityForResult(intent, AppConfig.REQUEST_CODE_SCAN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 扫描二维码/条码回传
                */
        if (requestCode == AppConfig.REQUEST_CODE_SCAN && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                LogUtils.d("扫描结果为：" + content);
            }
        }
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
}
