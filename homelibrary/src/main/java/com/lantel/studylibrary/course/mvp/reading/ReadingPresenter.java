package com.lantel.studylibrary.course.mvp.reading;

import android.os.Bundle;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;


public class ReadingPresenter extends ReadingContract.Presenter {
    public void setTag(int tag) {
        this.tag = tag;
    }

    private int tag;
    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {

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

    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    public void initData() {
        //添加菜单数据
        ArrayList<CourseCardModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            CourseCardModel model = new CourseCardModel("fz1","2019-05-25","2019-05-26",1,9);
            CourseCardModel mode2 = new CourseCardModel("fz2","2019-05-26","2019-05-29",2,8);
            menu.add(model);
            menu.add(mode2);
        }
        mView.initData(menu);
    }
}
