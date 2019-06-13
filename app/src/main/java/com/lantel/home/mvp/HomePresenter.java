package com.lantel.home.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.GlideImageLoader;
import com.lantel.common.HeaderUtil;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.home.api.HomeBean;
import com.lantel.home.api.HomeService;
import com.lantel.home.api.HomeTopModel;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class HomePresenter extends HomeContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("onStart: ");
    }

    @Override
    public void onResume() {
        LogUtils.d("onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("onCrete: ");
    }

    public void initMenu() {
        //添加菜单数据
        ArrayList<SimpleMenuModel> menu = new ArrayList<>();
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.home_menu_title);
        String[] router_paths = resources.getStringArray(R.array.home_menu_router_path);
        TypedArray icons = resources.obtainTypedArray(R.array.home_menu_icon);
        for (int i = 0; i < titles.length; i++) {
            SimpleMenuModel menuModel = new SimpleMenuModel();
            menuModel.setTitle(titles[i]);
            menuModel.setImgRes(icons.getResourceId(i,0));
            menuModel.setRouterpath(router_paths[i]);
            menu.add(menuModel);
        }
        mView.initMenuData(menu);
    }

    public void laodHomeTop() {
        HomeService homeService = Http.getInstance().createRequest(HomeService.class);
        homeService.getHomeData(HeaderUtil.getHeaderMap())
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<HomeBean>() {
                    @Override
                    public void onSuccess(HomeBean homeBean) {
                        int error = homeBean.getError();
                        if(error == 0){
                            HomeTopModel homeTopModel = new HomeTopModel();
                            HomeBean.DataBean dataBean = homeBean.getData();
                            if (null != dataBean) {
                                homeTopModel.setOrg_name(dataBean.getOrg_name());
                                homeTopModel.setBranch_address(dataBean.getBranch_address());
                                homeTopModel.setBranch_name(dataBean.getBranch_name());
                                homeTopModel.setBranch_tel(dataBean.getBranch_tel());
                                homeTopModel.setRecommend_cover(dataBean.getRecommend_cover());
                            }
                            mView.updateTopView(homeTopModel);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
    }
}
