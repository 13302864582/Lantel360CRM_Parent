package com.lantel.homelibrary.output.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class OutputPresenter extends OutputContract.Presenter{
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
        initMenu();
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

    public void initMenu() {
        //添加菜单数据
        ArrayList<BaseModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            BaseModel model = new CardOutputModel();
            ((CardOutputModel)model).setImgs(new String[]{"1","2","2","2"});
            ((CardOutputModel)model).setSupport(true);
            BaseModel mode2 = new CardOutputModel();
            ((CardOutputModel)mode2).setImgs(new String[]{"1","2"});
            ((CardOutputModel)mode2).setSupport(false);
            BaseModel mode3 = new CardOutputModel();
            ((CardOutputModel)mode3).setImgs(new String[]{"1"});
            ((CardOutputModel)mode3).setSupport(false);
            menu.add(model);
            menu.add(mode2);
            menu.add(mode3);
        }
        mView.initCourseData(menu);
    }

   /* public void refreshData(RefreshLayout refreshLayout) {
        loadData(String.valueOf(1),String.valueOf(10),false,refreshLayout);
    }

    private void loadData(String page, String pageSize, boolean isLoadMore, RefreshLayout refreshLayout) {
        mModel.loadData(page,pageSize)
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<ClassBean>() {
                    @Override
                    public void onSuccess(ClassBean data) {
                        if(data.getError()==0){
                            List<ClassBean.DataBean.ListBean> listBean = data.getData().getList();
                            //添加菜单数据
                            ArrayList<ClassesCardModel> menu = new ArrayList<>();
                            for (ClassBean.DataBean.ListBean  bean : listBean) {
                                ClassesCardModel model = new ClassesCardModel();
                                ClassBean.DataBean.ListBean.TeacherBean teacher = bean.getTeacher();
                                model.setHeaImg(teacher.getPhoto_url());
                                model.setTeacher(teacher.getEname());
                                model.setClassName(bean.getClass_name());
                                model.setPlace(bean.getClassroom().getRoom_name());
                                model.setTotal(bean.getArrange_times());
                                model.setPercent(bean.getAttendance_times());
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
                                menu.add(model);
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
    }*/

}
