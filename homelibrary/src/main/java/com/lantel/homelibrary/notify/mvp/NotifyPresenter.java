package com.lantel.homelibrary.notify.mvp;

import android.os.Bundle;
import com.lantel.homelibrary.notify.api.NotifyBean;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class NotifyPresenter extends NotifyContract.Presenter<NotifyBean,NotifyItemModel>{

    @Override
    protected void showLoading() {
        mView.showLoading();
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<NotifyItemModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<NotifyItemModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(NotifyBean data) {
        List<NotifyBean.DataBean.ListBean> listBeans= data.getData().getList();
        return null==listBeans?0:listBeans.size();
    }

    @Override
    protected int getErrorCode(NotifyBean data) {
        return data.getError();
    }

    @Override
    protected void setUpData(ArrayList<NotifyItemModel> list, NotifyBean data) {
        NotifyBean.DataBean dataBean = data.getData();
        if(null != dataBean){
            List<NotifyBean.DataBean.ListBean> listBeans = dataBean.getList();
            if(null != listBeans){
                for(NotifyBean.DataBean.ListBean listBean : listBeans){
                    NotifyItemModel itemModel = new NotifyItemModel();
                    itemModel.setTitle(listBean.getTitle());
                    itemModel.setTime(listBean.getCreate_time());
                    itemModel.setContent(listBean.getDesc());
                    itemModel.setPush(true);
                    list.add(itemModel);
                }
            }
        }
    }

    @Override
    protected String getErrorMessage(NotifyBean data) {
        return data.getMessage();
    }

    @Override
    protected Observable<NotifyBean> getObserver(boolean isMore) {
        if(!isMore)
            return mModel.loadData(String.valueOf(1),String.valueOf(10));
        else
            return mModel.loadData(String.valueOf(mCurrentPage+1),String.valueOf(10));
    }

    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {

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
}
