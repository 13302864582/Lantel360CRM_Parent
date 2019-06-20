package com.lantel.homelibrary.homework.mvp;

import android.os.Bundle;
import android.text.TextUtils;

import com.lantel.MyApplication;
import com.lantel.common.Lesson;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.homework.api.HomeWorkBean;
import com.lantel.homelibrary.homework.list.model.HomeWorkItemModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import io.reactivex.Observable;

public class HomeWorkPresenter extends HomeWorkContract.Presenter<HomeWorkBean, HomeWorkItemModel> {
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
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<HomeWorkItemModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<HomeWorkItemModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected Observable<HomeWorkBean> getObserver(boolean isMore) {
        String sid = SpCache.getString(Config.SID,"");
        if(!isMore)
            return mModel.loadData(sid,String.valueOf(1),String.valueOf(10));
        else
            return mModel.loadData(sid,String.valueOf(mCurrentPage+1),String.valueOf(10));
    }

    @Override
    protected int getTotal(HomeWorkBean data) {
        if(null == data.getData())
            return 0;
        return data.getData().getTotal();
    }

    @Override
    protected int getErrorCode(HomeWorkBean data) {
        return data.getError();
    }

    @Override
    protected void setUpData(ArrayList<HomeWorkItemModel> list, HomeWorkBean data) {
        HomeWorkBean.DataBean dataBean = data.getData();
        if(null != dataBean){
            HomeWorkBean.DataBean.IncompleteBean incompleteBean = dataBean.getIncomplete();
            if(null != incompleteBean){
                addIncompleteBeanData(list, incompleteBean);
            }

            HomeWorkBean.DataBean.CompleteBean completeBean = dataBean.getComplete();
            if(null != completeBean){
                addCompeleteData(list, completeBean);
            }
        }
    }

    private void addIncompleteBeanData(ArrayList<HomeWorkItemModel> list, HomeWorkBean.DataBean.IncompleteBean incompleteBean) {
        List<HomeWorkBean.DataBean.IncompleteBean.ListBeanX> incompleteBeanList = incompleteBean.getList();
        if(null != incompleteBeanList && incompleteBeanList.size()>0)
            for(HomeWorkBean.DataBean.IncompleteBean.ListBeanX bean :incompleteBeanList){
                HomeWorkItemModel model = new HomeWorkItemModel();
                String stime = DisplayUtil.getFormateStr("yyyy-MM-dd HH:mm:ss","yyyy-MM-dd",bean.getCreate_time());
                String start_time = String.format(context.getString(R.string.publish_time_format),stime);

                String etime = DisplayUtil.getFormateStr("yyyyMMdd","yyyy-MM-dd",bean.getDeadline()+"");
                String end_time = String.format(context.getString(R.string.deadline_time_format),etime);
                model.setStartTime(start_time);
                model.setEndTime(end_time);
                model.setFinish(false);
                model.setHt_id(bean.getHt_id());
                HomeWorkBean.DataBean.IncompleteBean.ListBeanX.EmployeeBeanX employeeBean = bean.getEmployee();
                if(null != employeeBean){
                    String imgUrl = employeeBean.getPhoto_url();
                    if(null != imgUrl)
                        model.setImgUrl(imgUrl);
                    String teacher = employeeBean.getEname();
                    if(null != teacher)
                        model.setTeacher(teacher);
                }
                String class_name = bean.getClass_name();
                if(!TextUtils.isEmpty(class_name)){
                    model.setClasses(class_name);
                } else {
                    MyApplication application = (MyApplication) context.getActivity().getApplication();
                    List<Lesson> lessonList = application.getLessonList();
                    if(null != lessonList && lessonList.size()>0){
                        for(Lesson lesson : lessonList){
                            if(lesson.getLid() == bean.getLid()){
                                model.setClasses(lesson.getLesson_name());
                            }
                        }
                    }
                }
                list.add(model);
            }
    }

    private void addCompeleteData(ArrayList<HomeWorkItemModel> list, HomeWorkBean.DataBean.CompleteBean completeBean) {
        List<HomeWorkBean.DataBean.CompleteBean.ListBean> completeBeanList = completeBean.getList();
        if(null != completeBeanList && completeBeanList.size()>0)
            for(HomeWorkBean.DataBean.CompleteBean.ListBean bean :completeBeanList){
                HomeWorkItemModel model = new HomeWorkItemModel();
                String stime = DisplayUtil.getFormateStr("yyyy-MM-dd HH:mm:ss","yyyy-MM-dd",bean.getCreate_time());
                String start_time = String.format(context.getString(R.string.publish_time_format),stime);

                String etime = DisplayUtil.getFormateStr("yyyyMMdd","yyyy-MM-dd",bean.getDeadline()+"");
                String end_time = String.format(context.getString(R.string.deadline_time_format),etime);
                model.setStartTime(start_time);
                model.setEndTime(end_time);
                model.setFinish(true);
                model.setHt_id(bean.getHt_id());
                HomeWorkBean.DataBean.CompleteBean.ListBean.EmployeeBean employeeBean = bean.getEmployee();
                if(null != employeeBean){
                    String imgUrl = employeeBean.getPhoto_url();
                    if(null != imgUrl)
                        model.setImgUrl(imgUrl);
                    String teacher = employeeBean.getEname();
                    if(null != teacher)
                        model.setTeacher(teacher);
                }
                    String class_name = bean.getClass_name();
                    if(!TextUtils.isEmpty(class_name)){
                        model.setClasses(class_name);
                    } else {
                    MyApplication application = (MyApplication) context.getActivity().getApplication();
                    List<Lesson> lessonList = application.getLessonList();
                    if(null != lessonList && lessonList.size()>0){
                        for(Lesson lesson : lessonList){
                            if(lesson.getLid() == bean.getLid()){
                                model.setClasses(lesson.getLesson_name());
                            }
                        }
                    }
                }
                list.add(model);
            }
    }

    @Override
    protected String getErrorMessage(HomeWorkBean data) {
        return data.getMessage();
    }
}
