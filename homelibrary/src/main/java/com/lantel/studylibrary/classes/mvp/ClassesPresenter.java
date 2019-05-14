package com.lantel.studylibrary.classes.mvp;

import android.os.Bundle;

import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ClassesPresenter extends ClassesContract.Presenter{
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
        ArrayList<ClassesCardModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ClassesCardModel model = new ClassesCardModel();
            model.setDate("20190112");
            model.setTime("0123");
            ClassesCardModel mode2 = new ClassesCardModel();
            mode2.setDate("20190112");
            mode2.setTime("0123");
            ClassesCardModel mode3 = new ClassesCardModel();
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
