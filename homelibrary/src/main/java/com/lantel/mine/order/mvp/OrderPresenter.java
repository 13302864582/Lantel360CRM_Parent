package com.lantel.mine.order.mvp;

import android.os.Bundle;
import com.google.gson.Gson;
import com.lantel.homelibrary.R;
import com.lantel.mine.order.api.OrderBean;
import com.lantel.mine.order.list.model.OrderItemModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class OrderPresenter extends OrderContract.Presenter{
    private int mCurrentPage = 0;

    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("===onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("===onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("===onStart: ");
        refreshData(null);
    }

    @Override
    public void onResume() {
        LogUtils.d("===onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("===onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("===onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("===onCrete: ");
    }

    public void refreshData(RefreshLayout refreshLayout) {
        mCurrentPage = 0;
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    public void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadOrderData(page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<OrderBean>() {
                    @Override
                    public void onSuccess(OrderBean data) {
                        if (data.getError() == 0) {
                            List<OrderBean.DataBean.ListBean> listBean = data.getData().getList();
                            if (listBean.size() == 0) {
                                mView.showEmpty();
                                if (null != refreshLayout)
                                    refreshLayout.finishRefresh();
                            } else {
                                //添加菜单数据
                                ArrayList<OrderItemModel> menu = new ArrayList<>();
                                for (OrderBean.DataBean.ListBean bean : listBean) {
                                   OrderItemModel model = new OrderItemModel();
                                   model.setOrderItemJson(new Gson().toJson(bean));
                                   if(null!=bean.getOrder_items()){
                                       int count = bean.getOrder_items().size();
                                       model.setCount("x"+count);
                                       if(count>0){
                                           OrderBean.DataBean.ListBean.OrderItemsBean orderItemsBean = bean.getOrder_items().get(0);
                                           model.setTitle(orderItemsBean.getItem_name());
                                           if(null!=orderItemsBean.getLesson())
                                           model.setImg(orderItemsBean.getLesson().getLesson_cover_picture());
                                       }
                                   }
                                    LogUtils.d("getCreate_time===="+bean.getCreate_time());
                                   model.setDate_time(bean.getCreate_time());
                                   model.setOrder_state(getOrderState(bean.getPay_status()));
                                   model.setMoney_record(bean.getPaid_amount());
                                   menu.add(model);
                                }
                                if (!isLoadMore) {
                                    mView.refreshData(menu);
                                    if (null != refreshLayout)
                                        refreshLayout.finishRefresh();
                                    mCurrentPage = 1;
                                } else {
                                    mView.setLoadMoreData(menu);
                                    if (null != refreshLayout)
                                        refreshLayout.finishLoadMore();
                                    mCurrentPage++;
                                }
                            }
                        } else {
                            onFailure(new Throwable(data.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        onFail(refreshLayout,isLoadMore);
                    }
                });
    }

    private String getOrderState(int pay_status) {
        String state = "";
        if(pay_status == 0){
            state = context.getString(R.string.un_pay);
        }else if(pay_status == 1){
            state = context.getString(R.string.part_pay);
        }else if(pay_status == 2){
            state = context.getString(R.string.success_pay);
        }
        return state;
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
    }

    public void onFail(RefreshLayout refreshLayout, boolean isLoadMore) {
        if (null != refreshLayout) {
            if (!isLoadMore)
                refreshLayout.finishRefresh();
            else
                refreshLayout.finishLoadMore();
        }
        if(!isLoadMore)
            mView.showEmpty();
    }
}
