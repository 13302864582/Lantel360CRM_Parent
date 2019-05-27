package com.lantel.studylibrary.course.fragment;

import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.lantel.studylibrary.course.mvp.has_read.HasReadContract;
import com.lantel.studylibrary.course.mvp.has_read.HasReadModel;
import com.lantel.studylibrary.course.mvp.has_read.HasReadPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import androidx.annotation.NonNull;

public class HasReadFrag extends BaseCourseFragment<HasReadPresenter, HasReadModel> implements HasReadContract.View , OnRefreshLoadMoreListener {
    @Override
    protected HasReadModel getModel() {
        return FindModel(HasReadModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        refreshlayout.setOnRefreshLoadMoreListener(this);
        super.initView();
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
    public void refreshData(ArrayList<CourseCardModel> menu) {
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadMoreData(ArrayList<CourseCardModel> menu) {
        int start = mAdapter.getDatas().size();
        mAdapter.getDatas().addAll(menu);
        mAdapter.notifyItemRangeInserted(start,menu.size());
        mAdapter.notifyItemRangeChanged(start,menu.size());
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
