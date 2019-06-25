package com.lantel.mine.wallet.mvp;

import android.os.Bundle;

import com.alibaba.android.arouter.utils.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lantel.common.HeaderUtil;
import com.lantel.mine.wallet.api.WalletOrderBean;
import com.lantel.mine.wallet.list.model.WalletItemModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.DisplayUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import okhttp3.ResponseBody;

public class WalletPresenter extends WalletContract.Presenter{
    private int mCurrentPage = 0;
    private String mCurrentMonth = "";
    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    //onActivityCreated
    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {
        refreshData(null);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    public void refreshData(RefreshLayout refreshLayout) {
        mCurrentPage = 0;
        if(TextUtils.isEmpty(mCurrentMonth))
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
        else
            loadMonthData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        if(TextUtils.isEmpty(mCurrentMonth))
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
        else
            loadMonthData(String.valueOf(mCurrentPage+1), String.valueOf(10), false, refreshLayout);
    }

    private void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<ResponseBody>() {
                    @Override
                    public void onSuccess(ResponseBody data) {
                        try {
                            JsonObject dataBean = new JsonParser().parse(data.string()).getAsJsonObject();
                            JsonObject listObject = dataBean.get("data").getAsJsonObject().get("list").getAsJsonObject();
                            if (dataBean.get("error").getAsInt() == 0) {
                                SetData(listObject, isLoadMore, refreshLayout);
                            } else if(dataBean.get("error").getAsInt()== 401){
                                HeaderUtil.goToLogin();
                            }else {
                                onFail(refreshLayout, isLoadMore);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            onFailure(new Throwable(e.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        onFail(refreshLayout, isLoadMore);
                    }
                });
    }

    private void SetData(JsonObject listObject, boolean isLoadMore, RefreshLayout refreshLayout) {
        Set<Map.Entry<String, JsonElement>> es = listObject.entrySet();
        ArrayList<WalletItemModel> userBeanList = new ArrayList<>();
        Gson gson = new Gson();
        for (Map.Entry<String, JsonElement> en : es) {
            JsonArray jsonArray = en.getValue().getAsJsonArray();
            //加强for循环遍历JsonArray
            for (JsonElement user : jsonArray) {
                //使用GSON，直接转成Bean对象
                WalletOrderBean walletOrderBean = gson.fromJson(user, WalletOrderBean.class);
                WalletItemModel model = new WalletItemModel();
                String amount = walletOrderBean.getAmount();
                String before_amount = walletOrderBean.getBefore_amount();
                String after_amount = walletOrderBean.getAfter_amount();
                if(null!=amount && null!=before_amount && null!=after_amount){
                    String famount = String.format("%.2f",Float.valueOf(amount));
                    String flag =  (Float.valueOf(after_amount)-Float.valueOf(before_amount))>0?"+":"-";
                    model.setMoney_record(flag+famount);
                }

                Date date = DisplayUtil.formatIntDay("yyyy-MM-dd HH:mm:ss",walletOrderBean.getCreate_time());
                model.setDate(date);
                model.setBusiness_type(walletOrderBean.getBusiness_type());
                model.setRemark(walletOrderBean.getRemark());
                userBeanList.add(model);
            }
        }
        if (!isLoadMore) {
            mView.refreshData(userBeanList);
            if (null != refreshLayout)
                refreshLayout.finishRefresh();
            mCurrentPage = 1;
        } else {
            mView.setLoadMoreData(userBeanList);
            if (null != refreshLayout)
                refreshLayout.finishLoadMore();
            mCurrentPage++;
        }
    }

    public void onTimeSelect(Date date) {
        mCurrentMonth = DisplayUtil.praseformatIntDay("yyyyMM", date);
        refreshData(null);
    }

    private void loadMonthData(String page, String pageSize,boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadMonthData(mCurrentMonth,page,pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<ResponseBody>() {
                    @Override
                    public void onSuccess(ResponseBody data) {
                        try {
                            JsonObject dataBean = new JsonParser().parse(data.string()).getAsJsonObject();
                            JsonObject listObject = dataBean.get("data").getAsJsonObject().get("list").getAsJsonObject();
                            if (dataBean.get("error").getAsInt() == 0) {
                                SetData(listObject, isLoadMore, refreshLayout);
                            }else if(dataBean.get("error").getAsInt()== 401){
                                HeaderUtil.goToLogin();
                            } else {
                                onFail(refreshLayout,isLoadMore);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            onFailure(new Throwable(e.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        onFail(refreshLayout, isLoadMore);
                    }
                });
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
