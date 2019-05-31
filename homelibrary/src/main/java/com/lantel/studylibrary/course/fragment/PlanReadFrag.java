package com.lantel.studylibrary.course.fragment;

import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadContract;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadModel;
import com.lantel.studylibrary.course.mvp.plan_read.PlanReadPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class PlanReadFrag extends BaseCourseFragment<PlanReadPresenter, PlanReadModel> implements PlanReadContract.View, OnRefreshLoadMoreListener {

    @Override
    protected PlanReadModel getModel() {
        return FindModel(PlanReadModel.class);
    }

    @Override
    protected void initView() {
        refreshlayout.setOnRefreshLoadMoreListener(this);
        super.initView();
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void refreshData(ArrayList<CourseCardModel> menu) {
        stateLayout.refreshLayout.setEnableLoadMore(false);
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<CourseCardModel> menu) {
        int start = mAdapter.getDatas().size();
        mAdapter.getDatas().addAll(menu);
        mAdapter.notifyItemRangeInserted(start,menu.size());
        mAdapter.notifyItemRangeChanged(start,menu.size());
    }

    @Override
    public void showEmpty() {
        stateLayout.showEmptyView();
    }

    @Override
    public void showLoading() {
        stateLayout.showLoadingView();
    }

    @Override
    public void showNetWorkError() {
        stateLayout.showFailView();
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPresenter.onLoadMore(refreshLayout);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.refreshData(refreshLayout);
    }
}
