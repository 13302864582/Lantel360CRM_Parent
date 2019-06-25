package com.lantel.homelibrary.course.mvp;

import android.os.Bundle;

import com.haibin.calendarview.Calendar;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.common.HttpResBean;
import com.lantel.common.NormalRxObserver;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.course.api.CourseBean;
import com.lantel.homelibrary.course.list.model.CourseAllBean;
import com.lantel.homelibrary.course.list.model.CourseItemModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CoursePresenter extends CourseContract.Presenter {
    private int mCurrentPage = 0;
    private String mCurrentIntDay = "";

    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("onCrete: ");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        mCurrentIntDay = format.format(new Date(System.currentTimeMillis()));
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

    public void refreshData(RefreshLayout refreshLayout) {
        loadData(String.valueOf(1), String.valueOf(10), false, refreshLayout);
    }

    private void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(mCurrentIntDay, page, pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<CourseAllBean>() {
                    @Override
                    public void onSuccess(CourseAllBean courseAllBean) {
                        setSchmeCalender(courseAllBean);
                        int error = courseAllBean.getCourseError();
                        List<CourseBean.DataBean.ListBean> listBean = courseAllBean.getListBeans();
                        setCourseList(error, listBean, isLoadMore, refreshLayout);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                      onFail(refreshLayout,isLoadMore);
                    }
                });
    }

    private void getCourse(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.getCourse(mCurrentIntDay, page, pageSize)
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new NormalRxObserver() {
                    @Override
                    public void onSuccess(HttpResBean resBean) {
                        CourseBean courseBean = (CourseBean) resBean;
                        List<CourseBean.DataBean.ListBean> listBean = courseBean.getData().getList();
                        setCourseList(courseBean.getError(), listBean, isLoadMore, refreshLayout);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                       onFail(refreshLayout,isLoadMore);
                    }
                });
    }

    private void setCourseList(int errorCode, List<CourseBean.DataBean.ListBean> listBean, boolean isLoadMore, RefreshLayout refreshLayout) {
        if (errorCode == 0) {
            ArrayList<CourseItemModel> menu = new ArrayList<>();

            for (CourseBean.DataBean.ListBean bean : listBean) {
                CourseItemModel itemModel = new CourseItemModel();
                if (null != bean.getLesson())
                    itemModel.setCourseName(String.format(context.getString(R.string.course_formate), bean.getLesson().getLesson_name()));
                if (null != bean.getTeacher())
                    itemModel.setTeacher(bean.getTeacher().getEname());
                if (null != bean.getTextbook_section() && null != bean.getTextbook()) {
                    CourseBean.DataBean.ListBean.TextbookSectionBean sectionBean = bean.getTextbook_section();
                    String tbName = bean.getTextbook().getTb_name();
                    itemModel.setSection(tbName + String.format(context.getString(R.string.sectionFormat), sectionBean.getSort()) + sectionBean.getSection_title());
                }
                itemModel.setCa_id(bean.getCa_id()+"");
                itemModel.setStartTime(DisplayUtil.getTimeString(bean.getInt_start_hour() + ""));
                itemModel.setEndTime(DisplayUtil.getTimeString(bean.getInt_end_hour() + ""));
                itemModel.setLeave(null == bean.getStudent_leave());
                menu.add(itemModel);
            }
            if (!isLoadMore) {
                mView.refreshData(menu);
                if (null != refreshLayout)
                    refreshLayout.finishRefresh();
                mCurrentPage = 1;
            } else {
                if (menu.size() != 0) {
                    mView.setLoadMoreData(menu);
                    mCurrentPage++;
                }
                if (null != refreshLayout)
                    refreshLayout.finishLoadMore();

            }
        }else if(errorCode == 401){
            HeaderUtil.goToLogin();
        } else {
            onFail(refreshLayout,isLoadMore);
        }
    }

    private Calendar getSchemeCalendar(int year, int month, int day) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month + 1);
        calendar.setDay(day);
        return calendar;
    }

    private void setSchmeCalender(CourseAllBean courseAllBean) {
        if (courseAllBean.getSchmeError() == 0) {
            HashMap<String, Calendar> map = new HashMap<>();
            List<Integer> dateList = courseAllBean.getSchmeDays();

            for (Integer int_day : dateList) {
                Date date = DisplayUtil.formatIntDay("yyyyMMdd", String.valueOf(int_day));
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(date);
                Calendar cal = getSchemeCalendar(calendar.get(java.util.Calendar.YEAR), calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.DAY_OF_MONTH));
                map.put(cal.toString(), cal);
            }
            mView.setSchemeDate(map);
        }
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(String.valueOf(mCurrentPage + 1), String.valueOf(10), true, refreshLayout);
    }

    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        if (isClick) {
            mCurrentIntDay = calendar.toString();
            getCourse(String.valueOf(mCurrentPage), String.valueOf(10), false, null);
        }
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
