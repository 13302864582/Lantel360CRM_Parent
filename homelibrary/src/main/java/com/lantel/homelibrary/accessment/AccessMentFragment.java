package com.lantel.homelibrary.accessment;

import android.view.View;
import com.example.baselibrary.R2;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.accessment.list.adpter.AccessAdapter;
import com.lantel.homelibrary.accessment.list.model.AccessItemModel;
import com.lantel.homelibrary.accessment.mvp.AccessContract;
import com.lantel.homelibrary.accessment.mvp.AccessModel;
import com.lantel.homelibrary.accessment.mvp.AccessPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class AccessMentFragment extends NormalListFragment<AccessPresenter, AccessModel> implements AccessContract.View {
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @Override
    protected void InitView() {
        stateLayout.showContentView();
    }

    @Override
    protected int getListView() {
        return R.id.recyclerView;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new AccessAdapter(getContext(),null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.accessment;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.common_list_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected AccessModel getModel() {
        return FindModel(AccessModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initAttenceData(ArrayList<AccessItemModel> menu) {
        AccessAdapter adapter = (AccessAdapter)mAdapter;
        adapter.setDatas(menu);
        adapter.notifyDataSetChanged();
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
