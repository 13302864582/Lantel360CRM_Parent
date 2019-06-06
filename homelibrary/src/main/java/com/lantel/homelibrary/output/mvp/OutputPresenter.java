package com.lantel.homelibrary.output.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.output.api.OutputBean;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.lantel.studylibrary.preview.preview.api.PreviewBean;
import com.lantel.studylibrary.preview.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class OutputPresenter extends OutputContract.Presenter<OutputBean, CardOutputModel> {
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
        refreshData(null);
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


    @Override
    protected void ViewSetLoadMoreData(ArrayList<CardOutputModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<CardOutputModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(OutputBean data) {
        if(null == data.getData())
            return 0;
        return data.getData().getTotal();
    }

    @Override
    protected int getErrorCode(OutputBean data) {
        return data.getError();
    }

    @Override
    protected void setUpData(ArrayList<CardOutputModel> list, OutputBean data) {

    }

    @Override
    protected String getErrorMessage(OutputBean data) {
        return data.getMessage();
    }

    @Override
    protected Observable<OutputBean> getObserver(boolean isMore) {
        return null;
    }
}
