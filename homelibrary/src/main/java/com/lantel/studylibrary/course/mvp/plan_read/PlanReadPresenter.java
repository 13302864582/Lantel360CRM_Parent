package com.lantel.studylibrary.course.mvp.plan_read;

import android.os.Bundle;

import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.lantel.studylibrary.course.api.CourseBean;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class PlanReadPresenter extends PlanReadContract.Presenter {
    private int mCurrentPage = 0;

    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

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


    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
    }

    public void refreshData(RefreshLayout refreshLayout) {
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    public void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<CourseBean>() {
                    @Override
                    public void onSuccess(CourseBean data) {
                        if (data.getError() == 0) {
                            List<CourseBean.DataBean.ListBean> listBean = data.getData().getList();
                            if(listBean.size() == 0){
                                mView.showEmpty();
                                if (null != refreshLayout)
                                    refreshLayout.finishRefresh();
                            }else {
                                //添加菜单数据
                                ArrayList<CourseCardModel> menu = new ArrayList<>();
                                for (CourseBean.DataBean.ListBean bean : listBean) {
                                    CourseCardModel model = new CourseCardModel();
                                    model.setCourse_name(bean.getLesson().getLesson_name());
                                    model.setCourse_start_date(DisplayUtil.getDateString(bean.getStart_int_day() + ""));
                                    model.setPercent(Integer.valueOf(bean.getUse_lesson_hours()));
                                    model.setTotal(Integer.valueOf(bean.getOrigin_lesson_hours()));
                                    model.setRemain(Integer.valueOf(bean.getRemain_lesson_hours()));
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
}
