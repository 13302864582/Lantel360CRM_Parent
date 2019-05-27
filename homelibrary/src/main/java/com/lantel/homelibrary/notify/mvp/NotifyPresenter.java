package com.lantel.homelibrary.notify.mvp;

import android.os.Bundle;
import com.lantel.common.XmlParser;
import com.lantel.homelibrary.notify.api.NotifyBean;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class NotifyPresenter extends NotifyContract.Presenter{
    private int mCurrentPage = 0;

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
    public void onCrete(Bundle savedInstanceState) {

    }

    public void refreshData(RefreshLayout refreshLayout) {
        loadData(String.valueOf(1),String.valueOf(10),false,refreshLayout);
    }

    private void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {

        mModel.loadData(page,pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<NotifyBean>() {
                    @Override
                    public void onSuccess(NotifyBean data) {
                        if(data.getError()==0){
                            List<NotifyBean.DataBean.ListBean> listBean = data.getData().getList();
                            //添加菜单数据
                            ArrayList<NotifyItemModel> menu = new ArrayList<>();
                            for (NotifyBean.DataBean.ListBean  bean : listBean) {
                                NotifyItemModel model = new NotifyItemModel();
                                model.setContent(XmlParser.xml2json(bean.getDesc()));
                                model.setTime(bean.getCreate_time());
                                model.setTitle(bean.getTitle());
                            }
                            if(!isLoadMore){
                                mView.refreshData(menu);
                                if(null!=refreshLayout)
                                    refreshLayout.finishRefresh();
                                mCurrentPage = 1;
                            }
                            else {
                                mView.setLoadMoreData(menu);
                                if(null!=refreshLayout)
                                    refreshLayout.finishLoadMore();
                                mCurrentPage++;
                            }

                        }else {
                            onFailure(new Throwable(data.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        if(null!=refreshLayout){
                            if(!isLoadMore)
                                refreshLayout.finishRefresh();
                            else
                                refreshLayout.finishLoadMore();
                        }
                        mView.showEmpty();
                    }
                });
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(String.valueOf(mCurrentPage+1),String.valueOf(10),true, refreshLayout);
    }
}
