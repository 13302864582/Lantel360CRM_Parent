package com.lantel.setting.bindfile.bindstudent;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.bindfile.bindstudent.list.adpter.BindStudentAdapter;
import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentContract;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentModel;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class BindStudentFragment extends NormalListFragment<BindStudentPresenter, BindStudentModel> implements BindStudentContract.View, OnRefreshListener {
    @BindView(R2.id.text_right)
    TextView add;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.common_list_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.toolbar_btt;
    }

    @Override
    protected BindStudentModel getModel() {
        return FindModel(BindStudentModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void InitView() {
        stateLayout.showContentView();
        add.setText(R.string.addFile);
    }

    @Override
    protected void initView() {
        initEmptyView();
        initLoadingView();
        initFailView();
        initToolBar();
        stateLayout.showContentView();
        recyclerView = rootView.findViewById(getListView());
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        mAdapter = getAdapter();
        recyclerView.setAdapter(mAdapter);
        stateLayout.refreshLayout.setEnableLoadMore(false);
        InitView();
    }

    @Override
    protected int getListView() {
        return R.id.recyclerView;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new BindStudentAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.bind_student;
    }

    @OnClick({R2.id.text_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.text_right){
            ARouter.getInstance().build("/lantel/360/Setting/BindAdd").navigation(getActivity(), Config.REQUEST_BIND_ADD);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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
    public void refreshData(ArrayList<BindStudentListModel> menu) {
        resetLoadMore();
        ((BindStudentAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<BindStudentListModel> menu) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.refreshData(refreshLayout);
    }
}
