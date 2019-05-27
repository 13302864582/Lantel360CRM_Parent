package com.lantel.homelibrary.notify;

import android.view.View;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.notify.list.adpter.NotifyAdapter;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.lantel.homelibrary.notify.mvp.NotifyContract;
import com.lantel.homelibrary.notify.mvp.NotifyModel;
import com.lantel.homelibrary.notify.mvp.NotifyPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class NotifyFragment extends ToolBarStateFragment<NotifyPresenter, NotifyModel> implements NotifyContract.View {
    @BindView(R2.id.refreshlayout)
    SmartRefreshLayout refreshlayout;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.attence_list)
    RecyclerView outputListView;

    private NotifyAdapter mAdapter;

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
        return R.layout.notify_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return -1;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected NotifyModel getModel() {
        return FindModel(NotifyModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        initToolBar();
        stateLayout.showContentView();
        outputListView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new NotifyAdapter(getContext(), null);
        outputListView.setAdapter(mAdapter);
    }

    private void initToolBar() {
        title.setText(getString(R.string.output));
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
    public void refreshData(ArrayList<NotifyItemModel> menu) {
       /* mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();*/
    }

    @Override
    public void setLoadMoreData(ArrayList<NotifyItemModel> menu) {

    }
}
