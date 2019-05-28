package com.lantel.homelibrary.classreview.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.classreview.api.ClassReviewBean;
import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassReviewPresenter extends ClassReviewContract.Presenter {
    private int mCurrentPage = 0;

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

    public void refreshData(RefreshLayout refreshLayout) {
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    private void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<ClassReviewBean>() {
                    @Override
                    public void onSuccess(ClassReviewBean data) {
                        if (data.getError() == 0) {
                            List<ClassReviewBean.DataBean.ListBean> listBean = data.getData().getList();
                            //添加菜单数据
                            ArrayList<ClassReviewCardModel> menu = new ArrayList<>();
                            for (ClassReviewBean.DataBean.ListBean bean : listBean) {
                                ClassReviewCardModel model = new ClassReviewCardModel();
                                ClassReviewBean.DataBean.ListBean.EmployeeBean employeeBean = bean.getEmployee();
                                model.setTeacherName(employeeBean.getEname());
                                model.setHeadImg(employeeBean.getPhoto_url());
                                model.setDate(bean.getCreate_time());
                                model.setContent(bean.getDetail());
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

                        } else {
                            onFailure(new Throwable(data.getMessage()));
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

    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
    }
}
