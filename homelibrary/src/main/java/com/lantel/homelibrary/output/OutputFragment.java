package com.lantel.homelibrary.output;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.output.list.adpter.OutputAdapter;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.lantel.homelibrary.output.mvp.OutputContract;
import com.lantel.homelibrary.output.mvp.OutputModel;
import com.lantel.homelibrary.output.mvp.OutputPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class OutputFragment extends ToolBarStateFragment<OutputPresenter, OutputModel> implements OutputContract.View, OnRefreshLoadMoreListener {
    @BindView(R2.id.output_listView)
    RecyclerView outputListView;
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    private OutputAdapter mAdapter;

    @Override
    protected int getContainerLayoutID() {
        return R.layout.common_container;
    }

    @Override
    protected int getFailViewId() {
        return R.id.fail;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.loading;
    }

    @Override
    protected int getEmptyViewId() {
        return R.id.empty;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.ouput_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.attence_toolbar;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected OutputModel getModel() {
        return FindModel(OutputModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        stateLayout.refreshLayout.setOnRefreshLoadMoreListener(this);
        initToolBar();
        stateLayout.showContentView();
        outputListView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new OutputAdapter(getContext(), null);
        outputListView.setAdapter(mAdapter);
        mPresenter.refreshData(null);
    }

    private void initToolBar() {
        title.setText(getString(R.string.output));
    }


    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
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
    public void refreshData(ArrayList<CardOutputModel> menu) {
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
    public void setLoadMoreData(ArrayList<CardOutputModel> menu) {
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
