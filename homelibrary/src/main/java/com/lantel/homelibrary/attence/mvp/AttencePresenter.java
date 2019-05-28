package com.lantel.homelibrary.attence.mvp;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.attence.api.AttenceBean;
import com.lantel.homelibrary.attence.list.model.AttenceCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import okhttp3.ResponseBody;

public class AttencePresenter extends AttenceContract.Presenter {
    private int mCurrentPage = 0;
    private String mCurrentDate = "";

    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("onStart: ");
        refreshData(null, false);
    }

    @Override
    public void onResume() {
        LogUtils.d("onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("onCrete: ");
    }

    public void refreshData(RefreshLayout refreshLayout, boolean isRangeMode) {
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
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

                            if(dataBean.get("error").getAsInt()==0){
                                SetData(listObject, isLoadMore, refreshLayout);
                            }else {
                                onFailure(new Throwable(dataBean.get("message").getAsString()));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            onFailure(new Throwable(e.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        if (null != refreshLayout) {
                            if (!isLoadMore)
                                refreshLayout.finishRefresh();
                            else
                                refreshLayout.finishLoadMore();
                        }
                        mView.showEmpty();
                    }
                });
    }

    private void loadRangeData(String int_day,String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadRangeData(int_day,page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<ResponseBody>() {
                    @Override
                    public void onSuccess(ResponseBody data) {
                        try {
                            JsonObject dataBean = new JsonParser().parse(data.string()).getAsJsonObject();
                            JsonObject listObject = dataBean.get("data").getAsJsonObject().get("list").getAsJsonObject();

                            if(dataBean.get("error").getAsInt()==0){
                                SetData(listObject, isLoadMore, refreshLayout);
                            }else {
                                onFailure(new Throwable(dataBean.get("message").getAsString()));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            onFailure(new Throwable(e.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        if (null != refreshLayout) {
                            if (!isLoadMore)
                                refreshLayout.finishRefresh();
                            else
                                refreshLayout.finishLoadMore();
                        }
                        mView.showEmpty();
                    }
                });
    }

    private void SetData(JsonObject listObject, boolean isLoadMore, RefreshLayout refreshLayout) {
        Set<Map.Entry<String, JsonElement>> es = listObject.entrySet();
        ArrayList<AttenceCardModel> userBeanList = new ArrayList<>();
        Gson gson = new Gson();
        for (Map.Entry<String, JsonElement> en : es) {
            JsonArray jsonArray = en.getValue().getAsJsonArray();
            //加强for循环遍历JsonArray
            for (JsonElement user : jsonArray) {
                //使用GSON，直接转成Bean对象
                AttenceBean userBean = gson.fromJson(user, AttenceBean.class);
                AttenceCardModel attenceCardModel = new AttenceCardModel();
                attenceCardModel.setDate(userBean.getInt_day()+"");
                attenceCardModel.setClassName(userBean.getCourse_arrange().getCourse_name());
                attenceCardModel.setTime(userBean.getInt_start_hour()+"");
                int attence = userBean.getIs_in();
                int leave = userBean.getIs_leave();
                attenceCardModel.setState(getStateInt(attence, leave));
                userBeanList.add(attenceCardModel);
            }
        }

        if(!isLoadMore){
            mView.refreshData(userBeanList);
            if(null!=refreshLayout)
                refreshLayout.finishRefresh();
            mCurrentPage = 1;
        }
        else {
            mView.setLoadMoreData(userBeanList);
            if(null!=refreshLayout)
                refreshLayout.finishLoadMore();
            mCurrentPage++;
        }
    }

    private int getStateInt(int attence, int leave) {
        if(attence == 1){
            //出勤
            return Config.STATE_NORMAL;
        }else {
            //缺勤
            if(leave == 0){
                //未请假,缺勤
                return Config.STATE_ABSENCE;
            }else {
                //请假
                return Config.STATE_LEAVE;
            }
        }
    }

    public void onLoadMore(RefreshLayout refreshLayout, boolean isRangeMode) {
        /*if(isRangeMode)
            loadRangeData(,String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
        else */
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
    }

    public void onTimeSelect(Date date) {
        mCurrentPage = 0;
        Date first = DisplayUtil.getSupportBeginDayofMonth(date,0);
        Date last = DisplayUtil.getSupportBeginDayofMonth(date,1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String sAgeFormat = context.getString(R.string.sAttenceDateFormat);
        mCurrentDate = String.format(sAgeFormat, dateFormat.format(first),dateFormat.format(last));
            loadRangeData(mCurrentDate,String.valueOf(mCurrentPage + 1), String.valueOf(10), false, null);
            LogUtils.d("onTimeSelect==="+mCurrentDate);


    }
}
