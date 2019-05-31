package com.lantel.homelibrary.attence;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.attence.list.adpter.AttenceAdapter;
import com.lantel.homelibrary.attence.list.model.AttenceCardModel;
import com.lantel.homelibrary.attence.mvp.AttenceContract;
import com.lantel.homelibrary.attence.mvp.AttenceModel;
import com.lantel.homelibrary.attence.mvp.AttencePresenter;
import com.lantel.mine.order.list.adpter.OrderAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.util.LogUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class AttenceFragment extends ToolBarStateFragment<AttencePresenter, AttenceModel> implements AttenceContract.View, OnTimeSelectListener, OnRefreshLoadMoreListener {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    @BindView(R2.id.attence_list)
    RecyclerView attenceList;
    @BindView(R2.id.refreshlayout)
    SmartRefreshLayout refreshLayout;
    private AttenceAdapter mAdapter;
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
        return R.layout.attence_content;
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
    protected AttenceModel getModel() {
        return FindModel(AttenceModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    protected void initView() {
        stateLayout.showContentView();
        filterDate.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        attenceList.setLayoutManager(manager);
        mAdapter = new AttenceAdapter(getContext(),null);
        attenceList.setAdapter(mAdapter);
        refreshLayout.setOnRefreshLoadMoreListener(this);
        stateLayout.refreshLayout.setEnableLoadMore(false);
        attenceList.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

    @OnClick({R2.id.back, R2.id.filter_date})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.filter_date) {
            TimePickerView timePicker = getTimePickerView();
            timePicker.show();
        } else if(id == R.id.back){
            getActivity().finish();
        }
    }

    private TimePickerView getTimePickerView() {
        //时间选择器
        Calendar calendar = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
        startDate.set(1993,0,1);
        endDate.set(2020,11,31);
        return new TimePickerBuilder(getContext(), this)
                .setType(new boolean[]{true, true, false,false,false,false})//分别对应年月日时分秒，默认全部显示
                .setCancelText(getString(R.string.pickerview_cancel))//取消按钮文字
                .setCancelColor(getResColor(R.color.time_pick_btn))
                .setSubmitColor(getResColor(R.color.time_pick_btn))
                .setSubmitText(getString(R.string.pickerview_submit))//确认按钮文字
                .setContentTextSize(25)//滚轮文字大小
                .setTitleSize(28)//标题文字大小
                .setTitleText(getString(R.string.select_time))//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setDate(calendar)
                .setRangDate(startDate,endDate)
                .setLabel("年","月","日","时","分","秒")
                .isDialog(false)
                .build();
    }

    @Override
    public void onTimeSelect(Date date, View v) {
        mPresenter.onTimeSelect(date);
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
    public void refreshData(ArrayList<AttenceCardModel> menu) {
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
    public void setLoadMoreData(ArrayList<AttenceCardModel> menu) {
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
