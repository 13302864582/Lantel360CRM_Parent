package com.lantel.live;

import android.view.View;

import com.lantel.homelibrary.R;
import com.lantel.live.list.adpter.LiveAdapter;
import com.lantel.live.list.model.LiveCardModel;
import com.lantel.live.mvp.LiveContract;
import com.lantel.live.mvp.LiveModel;
import com.lantel.live.mvp.LivePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LiveFragment extends NormalListFragment<LivePresenter, LiveModel> implements LiveContract.View, OnRefreshLoadMoreListener {
    @Override
    public void refreshData(ArrayList<LiveCardModel> menu) {
        resetLoadMore();
        ((LiveAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<LiveCardModel> menu) {
            if(null == menu || menu.size()==0)
            return;
            int start = ((LiveAdapter)mAdapter).getDatas().size();
            ((LiveAdapter)mAdapter).getDatas().addAll(menu);
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

    @Override
    protected void InitView() {
        stateLayout.refreshLayout.setOnRefreshLoadMoreListener(this);
        mPresenter.refreshData(null);
        rootView.findViewById(com.example.baselibrary.R.id.back).setVisibility(View.GONE);
    }

    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new LiveAdapter(getContext(),new ArrayList<>());
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.live_zhibo;
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
    protected LiveModel getModel() {
        return FindModel(LiveModel.class);
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
}
