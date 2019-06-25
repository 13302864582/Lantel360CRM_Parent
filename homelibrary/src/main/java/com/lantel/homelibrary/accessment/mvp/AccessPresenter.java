package com.lantel.homelibrary.accessment.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.accessment.list.model.AccessItemModel;

import java.util.ArrayList;

public class AccessPresenter extends AccessContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    //onActivityCreated
    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {
        initMenu();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

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
