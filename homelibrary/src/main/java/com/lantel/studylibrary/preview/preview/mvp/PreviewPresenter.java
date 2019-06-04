package com.lantel.studylibrary.preview.preview.mvp;

import android.os.Bundle;
import com.lantel.studylibrary.preview.preview.api.PreviewBean;
import com.lantel.studylibrary.preview.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class PreviewPresenter extends PreviewContract.Presenter<PreviewBean,PreviewItemModel>{
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
    protected void setUpData(ArrayList<PreviewItemModel> list, PreviewBean data) {
        List<PreviewBean.DataBean.ListBean> listBean = data.getData().getList();
        for (PreviewBean.DataBean.ListBean bean : listBean){
            PreviewItemModel model = new PreviewItemModel();
            model.setTitle(bean.getTitle());
            model.setDate(DisplayUtil.getDateString(bean.getInt_day()+""));
            String start_hour = DisplayUtil.getTimeString(bean.getInt_start_hour()+"");
            String end_hour = DisplayUtil.getTimeString(bean.getInt_end_hour()+"");
            model.setTime(start_hour+"-"+end_hour);
            model.setContent(bean.getContent());
            list.add(model);
        }

    }

    @Override
    protected int getErrorCode(PreviewBean data) {
        return data.getError();
    }

    @Override
    protected String getErrorMessage(PreviewBean data) {
        return data.getMessage();
    }

    @Override
    protected Observable<PreviewBean> getObserver(boolean isMore) {
        if(!isMore)
            return mModel.loadData(String.valueOf(1),String.valueOf(10));
            else
            return mModel.loadData(String.valueOf(mCurrentPage+1),String.valueOf(10));
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<PreviewItemModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<PreviewItemModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(PreviewBean data) {
        if(null == data.getData())
            return 0;
        return data.getData().getTotal();
    }
}
