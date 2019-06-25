package com.lantel.app.mvp;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lantel.Login.api.DeviceBean;
import com.lantel.Login.api.LoginBean;
import com.lantel.MyApplication;
import com.lantel.app.api.AllBean;
import com.lantel.common.ClassRoom;
import com.lantel.common.HeaderUtil;
import com.lantel.common.HttpResBean;
import com.lantel.common.Lesson;
import com.lantel.common.NormalRxObserver;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class AppPresenter extends AppContract.Presenter implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {
        //加载全局数据，保存后续会用的相关参数
        mModel.loadData()
                .compose(context.bindToLifecycle())
                .subscribe(new NormalRxObserver() {
                    @Override
                    public void onSuccess(HttpResBean allBean) {
                        AllBean.DataBean dataBean = ((AllBean)allBean).getData();
                        if(null != dataBean){
                            MyApplication application = (MyApplication) context.getApplication();

                            //保存班级教室信息
                            List<AllBean.DataBean.ClassroomsBean> classroomsBeans = dataBean.getClassrooms();
                            if(null != classroomsBeans && classroomsBeans.size()>0){
                                List<ClassRoom> classRoom = new ArrayList<>();
                                for(AllBean.DataBean.ClassroomsBean classroomsBean : classroomsBeans){
                                    ClassRoom room = new ClassRoom();
                                    room.setCr_id(classroomsBean.getCr_id());
                                    room.setRoom_name(classroomsBean.getRoom_name());
                                    classRoom.add(room);
                                }
                                application.setClassRoom(classRoom);
                            }

                            //保存请假类型信息
                            AllBean.DataBean.DictsBean dictsBean = dataBean.getDicts();
                            if(null != dictsBean){
                                List<BaseModel> leaveTypes  = new ArrayList<>();
                                List<AllBean.DataBean.DictsBean.LeaveReasonBean> leave_reasons = dictsBean.getLeave_reason();
                                for(AllBean.DataBean.DictsBean.LeaveReasonBean leaveReasonBean : leave_reasons){
                                    BaseModel model = new BaseModel();
                                    model.setType(leaveReasonBean.getDid());
                                    model.setTitle(leaveReasonBean.getTitle());
                                    leaveTypes.add(model);
                                }
                                application.setLeaveTypes(leaveTypes);
                            }

                            //保存课程类型信息
                            List<AllBean.DataBean.LessonsBean> lessons = dataBean.getLessons();
                            if(null != lessons && lessons.size()>0){
                                List<Lesson> lessonList = new ArrayList<>();
                                for(AllBean.DataBean.LessonsBean lessonsBean : lessons){
                                    Lesson lesson = new Lesson();
                                    lesson.setLid(lessonsBean.getLid());
                                    lesson.setLesson_name(lessonsBean.getLesson_name());
                                    lessonList.add(lesson);
                                }
                                application.setLessonList(lessonList);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                    }
                });

        //请求后台接口，传递设备的唯一ID，推送消息，添加角标
        String dev_id = SpCache.getString(Config.REGISTRATIONID,"");
        LogUtils.d("dev_id2==="+dev_id);
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setDoapp_device_id(dev_id);
        mModel.bindDevice(SpCache.getString(Config.UID,"0"),deviceBean).compose(context.bindToLifecycle())
        .subscribe(new BaseRxObserver<LoginBean>() {
            @Override
            public void onSuccess(LoginBean demo) {
             if(demo.getCode()== 401){
                    HeaderUtil.goToLogin();
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //点击底部导航
        switch (menuItem.getItemId()) {
            //切换到主页
            case R.id.item_home:
                mView.navigate(R.id.action_home);
                break;
            //切换到学习
            case R.id.item_study:
                mView.navigate(R.id.action_study);
                break;
            //切换到直播
            case R.id.item_zhibo:
                mView.navigate(R.id.action_live);
                break;
            //切换到我的
            case R.id.item_mine:
                mView.navigate(R.id.action_mine);
                break;
        }
        return true;
    }
}
