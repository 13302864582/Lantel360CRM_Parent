package com.lantel.homelibrary.communicate.mvp;

import android.os.Bundle;
import com.lantel.homelibrary.communicate.api.CommunicateBean;
import com.lantel.homelibrary.communicate.list.model.ItemModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import io.reactivex.Observable;

public class CommunicatePresenter extends CommunicateContract.Presenter<CommunicateBean, ItemModel> {
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
    protected void showLoading() {
        mView.showLoading();
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<ItemModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<ItemModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(CommunicateBean data) {
        return 10;
    }

    @Override
    protected int getErrorCode(CommunicateBean data) {
        return 0;
    }

    @Override
    protected void setUpData(ArrayList<ItemModel> list, CommunicateBean data) {

    }

    @Override
    protected void loadData(Observable<CommunicateBean> observable, boolean isLoadMore, RefreshLayout refreshLayout) {
            ArrayList<ItemModel> list = new ArrayList<>();
            for(int i=0;i<1;i++){
            ItemModel itemModel = new ItemModel();
            list.add(itemModel);
            }

            if (!isLoadMore)
                ViewRefreshData(list);
            else
                ViewSetLoadMoreData(list);
            FinishRefreshLoadMore(isLoadMore, refreshLayout);
            setUpCurrentPage(isLoadMore);
    }

    @Override
    protected String getErrorMessage(CommunicateBean data) {
        return "";
    }

    @Override
    protected Observable<CommunicateBean> getObserver(boolean isMore) {
        if(!isMore)
        return mModel.loadData(String.valueOf(mCurrentPage),String.valueOf(10));
        else
            return mModel.loadData(String.valueOf(mCurrentPage),String.valueOf(10));
    }

    @Override
    public void setUpCurrentPage(boolean isLoadMore) {
        //total : 总数,pageSize : 每页显示数，totalPage : 共页数
        int total = mView.getItemCount();
        int pageSize = 10;
        int totalPage = (total + pageSize - 1)/pageSize;
        if(total>10){
            mCurrentPage = totalPage;
        }else
            mCurrentPage=1;
    }
}
