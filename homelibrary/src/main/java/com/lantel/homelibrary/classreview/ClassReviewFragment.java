package com.lantel.homelibrary.classreview;

import android.view.View;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.classreview.list.adpter.ClassReviewAdapter;
import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.lantel.homelibrary.classreview.mvp.ClassReviewContract;
import com.lantel.homelibrary.classreview.mvp.ClassReviewModel;
import com.lantel.homelibrary.classreview.mvp.ClassReviewPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassReviewFragment extends NormalListFragment<ClassReviewPresenter, ClassReviewModel> implements ClassReviewContract.View, OnRefreshLoadMoreListener {
    @Override
    protected void InitView() {
        stateLayout.refreshLayout.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ClassReviewAdapter(getContext(),null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.class_review;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.attence_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected ClassReviewModel getModel() {
        return FindModel(ClassReviewModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
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

    @Override
    public void refreshData(ArrayList<ClassReviewCardModel> menu) {
        stateLayout.showContentView();
        ((ClassReviewAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadMoreData(ArrayList<ClassReviewCardModel> menu) {
        List<ClassReviewCardModel> list = ((ClassReviewAdapter)mAdapter).getDatas();
        int start = list.size();
        list.addAll(menu);
        mAdapter.notifyItemRangeInserted(start,menu.size());
        mAdapter.notifyItemRangeChanged(start,menu.size());
    }
}
