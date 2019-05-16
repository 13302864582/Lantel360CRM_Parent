package com.lantel.homelibrary.output.mvp;

import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;

public class OutputDetailPresenter extends OutputDetailContract.Presenter{
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
        BaseModel model = new CardOutputModel();
        ((CardOutputModel)model).setImgs(new String[]{"1","2","2","2"});
        ((CardOutputModel)model).setSupport(true);
        mView.initCourseData(model);
    }

}
