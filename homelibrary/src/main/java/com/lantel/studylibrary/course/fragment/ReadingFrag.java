package com.lantel.studylibrary.course.fragment;

import com.lantel.homelibrary.R;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.lantel.studylibrary.course.mvp.reading.ReadingContract;
import com.lantel.studylibrary.course.mvp.reading.ReadingModel;
import com.lantel.studylibrary.course.mvp.reading.ReadingPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class ReadingFrag extends BaseCourseFragment<ReadingPresenter, ReadingModel> implements ReadingContract.View, OnRefreshLoadMoreListener {
    @Override
    protected ReadingModel getModel() {
        return FindModel(ReadingModel.class);
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
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
        stateLayout.showContentView();
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
