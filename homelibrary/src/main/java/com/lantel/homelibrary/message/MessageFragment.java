package com.lantel.homelibrary.message;

import android.view.View;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.message.list.adpter.MessageAdapter;
import com.lantel.homelibrary.message.list.model.MessageItemModel;
import com.lantel.homelibrary.message.mvp.MessageContract;
import com.lantel.homelibrary.message.mvp.MessageModel;
import com.lantel.homelibrary.message.mvp.MessagePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class MessageFragment extends NormalListFragment<MessagePresenter, MessageModel> implements MessageContract.View, OnRefreshLoadMoreListener {
    @BindView(R2.id.refreshlayout)
    SmartRefreshLayout refreshlayout;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.attence_list)
    RecyclerView outputListView;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.attence_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected MessageModel getModel() {
        return FindModel(MessageModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void InitView() {
        stateLayout.refreshLayout.setOnRefreshLoadMoreListener(this);
        mPresenter.refreshData(null);
    }

    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MessageAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.notify;
    }


    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back){
            getActivity().finish();
        }
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
    public void refreshData(ArrayList<MessageItemModel> menu) {
       resetLoadMore();
        ((MessageAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<MessageItemModel> menu) {
        int start = ((MessageAdapter)mAdapter).getDatas().size();
        ((MessageAdapter)mAdapter).getDatas().addAll(menu);
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
