package com.lantel.studylibrary.course.fragment;

import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.lantel.studylibrary.course.mvp.reading.ReadingContract;
import com.lantel.studylibrary.course.mvp.reading.ReadingModel;
import com.lantel.studylibrary.course.mvp.reading.ReadingPresenter;
import java.util.ArrayList;

public class ReadingFrag extends BaseCourseFragment<ReadingPresenter, ReadingModel> implements ReadingContract.View {
    @Override
    protected void PresenterSetTag() {
        mPresenter.setTag(getFragmentTag());
        mPresenter.initData();
    }

    @Override
    protected int getFragmentTag() {
        return Config.TAG_READING;
    }

    @Override
    protected ReadingModel getModel() {
        return FindModel(ReadingModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initData(ArrayList<CourseCardModel> menu) {
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFail() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }
}
