package com.lantel.studylibrary.course.fragment;

import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadContract;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadModel;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadPresenter;
import java.util.ArrayList;


public class PlanReadFrag extends BaseCourseFragment<PlanReadPresenter, PlanReadModel> implements PlanReadContract.View {
    @Override
    protected void PresenterSetTag() {
        mPresenter.setTag(getFragmentTag());
    }

    @Override
    protected int getFragmentTag() {
        return Config.TAG_READ_PLAN;
    }

    @Override
    protected PlanReadModel getModel() {
        return FindModel(PlanReadModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initAttenceData(ArrayList<CourseCardModel> menu) {
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }
}
