package com.lantel.homelibrary.message.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.message.api.MessageBean;
import com.lantel.homelibrary.message.list.model.MessageItemModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MessagePresenter extends MessageContract.Presenter<MessageBean, MessageItemModel>{

    @Override
    protected void showLoading() {
        mView.showLoading();
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<MessageItemModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<MessageItemModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(MessageBean data) {
        List<MessageBean.DataBean.ListBean> listBeans= data.getData().getList();
        return null==listBeans?0:listBeans.size();
    }

    @Override
    protected int getErrorCode(MessageBean data) {
        return data.getError();
    }

    @Override
    protected void setUpData(ArrayList<MessageItemModel> list, MessageBean data) {
        MessageBean.DataBean dataBean = data.getData();
        if(null != dataBean){
            List<MessageBean.DataBean.ListBean> listBeans = dataBean.getList();
            if(null != listBeans){
                for(MessageBean.DataBean.ListBean listBean : listBeans){
                    MessageItemModel itemModel = new MessageItemModel();
                    itemModel.setTitle(listBean.getTitle());
                    itemModel.setBusiness_type(listBean.getBusiness_type());
                    itemModel.setBusiness_id(listBean.getBusiness_id());
                    itemModel.setContent(listBean.getContent());
                    list.add(itemModel);
                }
            }
        }
    }

    @Override
    protected String getErrorMessage(MessageBean data) {
        return data.getMessage();
    }

    @Override
    protected Observable<MessageBean> getObserver(boolean isMore) {
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
