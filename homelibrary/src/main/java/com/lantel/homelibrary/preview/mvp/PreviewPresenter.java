package com.lantel.homelibrary.preview.mvp;

import android.os.Bundle;
import com.lantel.homelibrary.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;

public class PreviewPresenter extends PreviewContract.Presenter{
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
        ArrayList<PreviewItemModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            PreviewItemModel model = new PreviewItemModel();
            menu.add(model);
        }
        mView.initAttenceData(menu);
    }
}