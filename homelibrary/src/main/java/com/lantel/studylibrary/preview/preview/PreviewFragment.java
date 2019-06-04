package com.lantel.studylibrary.preview.preview;

import android.view.View;
import com.lantel.homelibrary.R;
import com.lantel.studylibrary.preview.preview.list.adpter.PreviewAdapter;
import com.lantel.studylibrary.preview.preview.list.model.PreviewItemModel;
import com.lantel.studylibrary.preview.preview.mvp.PreviewContract;
import com.lantel.studylibrary.preview.preview.mvp.PreviewModel;
import com.lantel.studylibrary.preview.preview.mvp.PreviewPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PreviewFragment extends NormalListFragment<PreviewPresenter, PreviewModel> implements PreviewContract.View, OnRefreshLoadMoreListener {
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
        return new PreviewAdapter(getContext(),null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.preview;
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
    protected PreviewModel getModel() {
        return FindModel(PreviewModel.class);
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
    public void refreshData(ArrayList<PreviewItemModel> menu) {
        stateLayout.refreshLayout.setEnableLoadMore(false);
        ((PreviewAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<PreviewItemModel> menu) {
        int start = ((PreviewAdapter)mAdapter).getDatas().size();
        ((PreviewAdapter)mAdapter).getDatas().addAll(menu);
        mAdapter.notifyItemRangeInserted(start,menu.size());
        mAdapter.notifyItemRangeChanged(start,menu.size());
    }
}
