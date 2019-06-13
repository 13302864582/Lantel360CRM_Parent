package com.lantel.homelibrary.homework.mvp;

import android.os.Bundle;
import com.lantel.homelibrary.homework.api.HomeWorkBean;
import com.lantel.homelibrary.homework.list.model.HomeWorkItemModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
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
        if(!isMore)
            return mModel.loadData(String.valueOf(1),String.valueOf(10));
        else
            return mModel.loadData(String.valueOf(mCurrentPage+1),String.valueOf(10));
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
            List<HomeWorkBean.DataBean.ListBean> listBeans = dataBean.getList();
            if(null != listBeans)
            for(HomeWorkBean.DataBean.ListBean listBean :listBeans){
                HomeWorkItemModel model = new HomeWorkItemModel();
                HomeWorkBean.DataBean.ListBean.EmployeeBean employeeBean = listBean.getEmployee();
                if(null != employeeBean){
                    String imgUrl = employeeBean.getPhoto_url();
                    if(null != imgUrl)
                    model.setImgUrl(imgUrl);

                    model.setFinish(null == imgUrl);

                    String teacher = employeeBean.getEname();
                    if(null != teacher)
                        model.setTeacher(teacher);
                }
                HomeWorkBean.DataBean.ListBean.OneClassBean oneClassBean = listBean.getOne_class();
                if(null != oneClassBean){
                    String class_name = oneClassBean.getClass_name();
                    if(null != class_name)
                        model.setClasses(class_name);
                }
            }
        }
    }

    @Override
    protected String getErrorMessage(HomeWorkBean data) {
        return data.getMessage();
    }
}
