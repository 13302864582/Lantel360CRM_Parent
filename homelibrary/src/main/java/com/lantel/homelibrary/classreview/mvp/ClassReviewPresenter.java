package com.lantel.homelibrary.classreview.mvp;

import android.os.Bundle;

import com.lantel.common.HttpResBean;
import com.lantel.common.NormalRxObserver;
import com.lantel.homelibrary.classreview.api.ClassReviewBean;
import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class ClassReviewPresenter extends ClassReviewContract.Presenter {
    private int mCurrentPage = 0;

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
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    private void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new NormalRxObserver() {
                    @Override
                    public void onSuccess(HttpResBean resBean) {
                        ClassReviewBean data = (ClassReviewBean) resBean;
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
                            model.setRvw_id(bean.getRvw_id());
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

                    @Override
                    public void onFailure(Throwable e) {
                        onFail(refreshLayout,isLoadMore);
                    }
                });
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
