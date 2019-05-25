package com.lantel.mine.order.mvp;

import android.os.Bundle;

import com.xiao360.baselibrary.util.LogUtils;

public class OrderPresenter extends OrderContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("===onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("===onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("===onStart: ");
    }

    @Override
    public void onResume() {
        LogUtils.d("===onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("===onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("===onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("===onCrete: ");
    }

    public void initMenuList() {
        //添加菜单数据
      /*  ArrayList<SimpleMenuModel> menu = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            SimpleMenuModel menuModel = new SimpleMenuModel();
            menuModel.setTitle(titles[i]);
            menuModel.setImgRes(icons.getResourceId(i,0));
            menuModel.setRouterpath(router_paths[i]);
            menu.add(menuModel);
        }
        mView.initMenuData(menu);*/
    }
}
