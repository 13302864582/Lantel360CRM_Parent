package com.lantel.homelibrary.accessment.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.accessment.list.model.AccessItemModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;

public class AccessPresenter extends AccessContract.Presenter{
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
        initMenu();
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
        ArrayList<AccessItemModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            AccessItemModel mode = new AccessItemModel();

            menu.add(mode);
        }
        mView.initAttenceData(menu);
    }

}
