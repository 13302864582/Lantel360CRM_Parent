package com.lantel.studylibrary.classes.mvp;

import android.os.Bundle;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import java.util.ArrayList;
import java.util.List;

public class ClassesPresenter extends ClassesContract.Presenter {
    private int mCurrentPage = 1;

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
    }
}
