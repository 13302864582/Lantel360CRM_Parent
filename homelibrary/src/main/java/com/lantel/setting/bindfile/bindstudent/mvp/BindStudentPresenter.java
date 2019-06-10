package com.lantel.setting.bindfile.bindstudent.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.R;
import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;

public class BindStudentPresenter extends BindStudentContract.Presenter{
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
        ArrayList<BindStudentListModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            BindStudentListModel model = new BindStudentListModel();
            model.setName("董丽丽");
            model.setAge("12");
            model.setHeaImg(R.mipmap.ad);
            model.setClass_room("广东省珠海市香洲区1121班");
            model.setClass_area("广州白云校区");
            model.setSex(true);
            model.setBind(true);
            menu.add(model);
        }
        mView.initAttenceData(menu);
    }

}
