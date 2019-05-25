package com.lantel.studylibrary.classes.mvp;

import android.os.Bundle;

import com.lantel.homelibrary.R;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassesPresenter extends ClassesContract.Presenter {
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
        mModel.loadData()
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
                            mView.setData(menu);
                        }else {
                            onFailure(new Throwable(data.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                            mView.showFail();
                    }
                });
    }

}
