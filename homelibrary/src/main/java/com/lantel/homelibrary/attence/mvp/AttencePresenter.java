package com.lantel.homelibrary.attence.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.attence.list.model.AttenceCardModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;

public class AttencePresenter extends AttenceContract.Presenter{
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
        ArrayList<AttenceCardModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            AttenceCardModel model = new AttenceCardModel();
            model.setDate("20190112");
            model.setTime("0123");
            AttenceCardModel mode2 = new AttenceCardModel();
            mode2.setDate("20190112");
            mode2.setTime("0123");
            AttenceCardModel mode3 = new AttenceCardModel();
            mode3.setDate("20190113");
            mode3.setTime("0125");
            menu.add(model);
            menu.add(mode2);
            menu.add(mode3);
        }
        Collections.sort(menu);
        mView.initAttenceData(menu);
    }

}
