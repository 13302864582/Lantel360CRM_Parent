package com.lantel.homelibrary.output.mvp;

import android.os.Bundle;

import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

public class OutputPresenter extends OutputContract.Presenter{
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
        ArrayList<BaseModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            BaseModel model = new BaseModel();
            model.setType(0);
            BaseModel mode2 = new BaseModel();
            mode2.setType(1);
            menu.add(model);
            menu.add(mode2);
        }
        mView.initCourseData(menu);
    }

}
