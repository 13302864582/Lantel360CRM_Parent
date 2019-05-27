package com.lantel.studylibrary.classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.studylibrary.classes.list.adpter.ClassesAdapter;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.lantel.studylibrary.classes.mvp.ClassesContract;
import com.lantel.studylibrary.classes.mvp.ClassesModel;
import com.lantel.studylibrary.classes.mvp.ClassesPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class ClassesFragment extends ToolBarStateFragment<ClassesPresenter, ClassesModel> implements ClassesContract.View, OnRefreshLoadMoreListener {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.classes_list)
    RecyclerView classes_list;
    private ClassesAdapter mAdapter;
    private boolean hasLoadMore = false;

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
        return R.layout.classes_content;
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
    protected ClassesModel getModel() {
        return FindModel(ClassesModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        showLoading();
        title.setText(R.string.classes);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        classes_list.setLayoutManager(manager);
        mAdapter = new ClassesAdapter(getContext(),null);
        classes_list.setAdapter(mAdapter);
        stateLayout.refreshLayout.setOnRefreshLoadMoreListener(this);
        stateLayout.refreshLayout.setEnableLoadMore(false);
        classes_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisible = manager.findLastVisibleItemPosition();
                if(!hasLoadMore && lastVisible>=9){
                    stateLayout.refreshLayout.setEnableLoadMore(true);
                    hasLoadMore = true;
                }
            }
        });
    }

    @Override
    public void refreshData(ArrayList<ClassesCardModel> menu) {
        stateLayout.showContentView();
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadMoreData(ArrayList<ClassesCardModel> menu) {
        int start = mAdapter.getDatas().size();
        mAdapter.getDatas().addAll(menu);
        mAdapter.notifyItemRangeInserted(start,menu.size());
        mAdapter.notifyItemRangeChanged(start,menu.size());
    }

    @OnClick({R2.id.back})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
            getActivity().finish();
        }
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
    public void showEmpty() {
        stateLayout.showFailView();
    }

    @Override
    public void showLoading() {
        stateLayout.showLoadingView();
    }

    @Override
    public void showNetWorkError() {
        stateLayout.showEmptyView();
    }
}
