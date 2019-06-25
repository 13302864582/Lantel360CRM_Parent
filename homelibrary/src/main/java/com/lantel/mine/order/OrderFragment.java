package com.lantel.mine.order;

import android.view.View;
import com.lantel.homelibrary.R;
import com.lantel.mine.order.list.adpter.OrderAdapter;
import com.lantel.mine.order.list.model.OrderItemModel;
import com.lantel.mine.order.mvp.OrderContract;
import com.lantel.mine.order.mvp.OrderModel;
import com.lantel.mine.order.mvp.OrderPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderFragment extends NormalListFragment<OrderPresenter, OrderModel> implements OrderContract.View, OnRefreshLoadMoreListener {
    @Override
    protected void InitView() {

    }

    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new OrderAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.order;
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
    protected OrderModel getModel() {
        return FindModel(OrderModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
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
    public void refreshData(ArrayList<OrderItemModel> menu) {
        resetLoadMore();
        ((OrderAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<OrderItemModel> menu) {
        OrderAdapter adapter = ((OrderAdapter)mAdapter);
        int start = adapter.getDatas().size();
        adapter.getDatas().addAll(menu);
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
