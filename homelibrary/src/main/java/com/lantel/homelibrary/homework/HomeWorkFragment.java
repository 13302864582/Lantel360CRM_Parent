package com.lantel.homelibrary.homework;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.cangwang.core.ModuleEvent;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.homework.list.ClickDetail;
import com.lantel.homelibrary.homework.list.adpter.HomeWrokAdapter;
import com.lantel.homelibrary.homework.list.model.HomeWorkItemModel;
import com.lantel.homelibrary.homework.mvp.HomeWorkContract;
import com.lantel.homelibrary.homework.mvp.HomeWorkModel;
import com.lantel.homelibrary.homework.mvp.HomeWorkPresenter;
import com.lantel.homelibrary.notify.list.adpter.NotifyAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeWorkFragment extends NormalListFragment<HomeWorkPresenter, HomeWorkModel> implements HomeWorkContract.View, OnRefreshLoadMoreListener, ClickDetail {

    @Override
    public void refreshData(ArrayList<HomeWorkItemModel> menu) {
        stateLayout.refreshLayout.setEnableLoadMore(false);
        ((HomeWrokAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @ModuleEvent(coreClientClass = HomeWorkClient.class)
    public void refreshHomework(String s) {
       mPresenter.refreshData(null);
    }

    @Override
    public void setLoadMoreData(ArrayList<HomeWorkItemModel> menu) {
        int start = ((HomeWrokAdapter)mAdapter).getDatas().size();
        ((HomeWrokAdapter)mAdapter).getDatas().addAll(menu);
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
    protected RecyclerView.Adapter getAdapter() {
        HomeWrokAdapter adapter = new HomeWrokAdapter(getContext(),null);
        adapter.setClickDetail(this);
        return adapter;
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
    protected int getToolbarTitle() {
        return R.string.homework;
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
    protected HomeWorkModel getModel() {
        return FindModel(HomeWorkModel.class);
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

    }

    @Override
    public void clickDetail(int ht_id, boolean isFinish) {
        ARouter.getInstance().build("/lantel/360/homework/detail").withInt(Config.BUSINESS_ID,ht_id).withBoolean(Config.IS_FINISH,isFinish).navigation(getActivity(),Config.REQUEST_HOMEDETAIL);
    }


}
