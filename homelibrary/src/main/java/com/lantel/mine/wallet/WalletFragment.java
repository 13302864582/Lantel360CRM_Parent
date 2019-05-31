package com.lantel.mine.wallet;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.mine.wallet.list.adpter.WalletAdapter;
import com.lantel.mine.wallet.list.model.WalletItemModel;
import com.lantel.mine.wallet.mvp.WalletContract;
import com.lantel.mine.wallet.mvp.WalletModel;
import com.lantel.mine.wallet.mvp.WalletPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class WalletFragment extends NormalListFragment<WalletPresenter, WalletModel> implements WalletContract.View, OnTimeSelectListener, OnRefreshLoadMoreListener {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.money)
    TextView money;
   /* @BindView(R2.id.date_title)
    TextView dateTitle;*/
    @BindView(R2.id.filter_date)
    ImageView filter_date;

    @Override
    protected void InitView() {
        WalletModel walletModel = ViewModelProviders.of(getActivity()).get(WalletModel.class);
        money.setText(walletModel.getWalletMoney());
        filter_date.setImageResource(R.mipmap.filter_date);
        filter_date.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.wallet_toolbar;
    }

    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new WalletAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.wallet;
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
    protected WalletModel getModel() {
        return FindModel(WalletModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @OnClick(R2.id.filter_date)
    public void onViewClicked(View v) {
        getTimePickerView().show();
    }

    private TimePickerView getTimePickerView() {
        //时间选择器
        Calendar calendar = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
        startDate.set(1993,0,1);
        endDate.set(2020,11,31);
        return new TimePickerBuilder(getContext(),this)
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

    public void refreshData(ArrayList<WalletItemModel> menu) {
        stateLayout.refreshLayout.setEnableLoadMore(false);
        WalletAdapter walletAdapter = (WalletAdapter) mAdapter;
        if(menu.size()!=0){
            stateLayout.showContentView();
        } else{
            stateLayout.showEmptyView();
        }

        walletAdapter.setDatas(menu);
        walletAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadMoreData(ArrayList<WalletItemModel> menu) {
        WalletAdapter walletAdapter = (WalletAdapter) mAdapter;
        int start = walletAdapter.getDatas().size();
        walletAdapter.getDatas().addAll(menu);
        walletAdapter.notifyItemRangeInserted(start,menu.size());
        walletAdapter.notifyItemRangeChanged(start,menu.size());
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
