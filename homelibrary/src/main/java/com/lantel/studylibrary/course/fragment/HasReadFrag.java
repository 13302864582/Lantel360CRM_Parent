package com.lantel.studylibrary.course.fragment;

import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadModel;
import com.lantel.studylibrary.course.mvp.reading.ReadingContract;
import com.lantel.studylibrary.course.mvp.reading.ReadingModel;
import com.lantel.studylibrary.course.mvp.reading.ReadingPresenter;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;

import androidx.lifecycle.ViewModel;

public class HasReadFrag extends BaseCourseFragment<ReadingPresenter, ReadingModel> implements ReadingContract.View {
    @Override
    protected void PresenterSetTag() {
        mPresenter.setTag(getFragmentTag());
    }

    @Override
    protected int getFragmentTag() {
        return Config.TAG_HAS_READ;
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
}
