package com.lantel.studylibrary.course.mvp.has_read;

import android.os.Bundle;

import com.lantel.common.HttpResBean;
import com.lantel.common.NormalRxObserver;
import com.lantel.studylibrary.course.api.CourseBean;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class HasReadPresenter extends HasReadContract.Presenter {
    private int mCurrentPage = 0;

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

    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
    }

    public void refreshData(RefreshLayout refreshLayout) {
        if(null == refreshLayout)
        mView.showLoading();

        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    public void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new NormalRxObserver() {
                    @Override
                    public void onSuccess(HttpResBean resBean) {
                        CourseBean data = (CourseBean) resBean;
                        List<CourseBean.DataBean.ListBean> listBean = data.getData().getList();
                        if(listBean.size() == 0){
                            mView.showEmpty();
                            if (null != refreshLayout)
                                refreshLayout.finishRefresh();
                        }else {
                            //添加数据
                            ArrayList<CourseCardModel> menu = new ArrayList<>();
                            for (CourseBean.DataBean.ListBean bean : listBean) {
                                CourseCardModel model = new CourseCardModel();
                                model.setCourse_start_date(DisplayUtil.getDateString(bean.getStart_int_day() + ""));
                                model.setCourse_end_date(DisplayUtil.getDateString(bean.getEnd_int_day() + ""));
                                if(null!=bean.getLesson())
                                    model.setCourse_name(bean.getLesson().getLesson_name());
                                setProgress(bean, model);
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
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        onFail(refreshLayout,isLoadMore);
                    }
                });
    }

    public void setProgress(CourseBean.DataBean.ListBean bean, CourseCardModel model) {
        //1:按课次计费,2:课时收费,3:按时间收费
        int price_type = bean.getPrice_type();
        float total = 0f;
        float remain = 0f;
        if(price_type == 2){
            total = Float.valueOf(bean.getLesson_hours());
            remain = Float.valueOf(bean.getRemain_lesson_hours());
        }else if(price_type == 1){
            total = Float.valueOf(bean.getLesson_times());
            remain = Float.valueOf(bean.getRemain_times());
        }
        float percent = total - remain;
        model.setPercent(percent);
        model.setTotal(total);
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
