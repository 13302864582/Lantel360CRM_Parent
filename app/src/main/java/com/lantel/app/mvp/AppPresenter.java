package com.lantel.app.mvp;

import android.provider.Settings;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.Login.api.LoginBean;
import com.lantel.Login.api.LoginService;
import com.lantel.MyApplication;
import com.lantel.app.api.AllBean;
import com.lantel.common.ClassRoom;
import com.lantel.common.Lesson;
import com.lantel.common.SchoolArea;
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
        mModel.loadData()
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<AllBean>() {
                    @Override
                    public void onSuccess(AllBean allBean) {
                        int errorCode  = allBean.getError();
                        if(errorCode == 0){
                            AllBean.DataBean dataBean = allBean.getData();
                            if(null != dataBean){
                                MyApplication application = (MyApplication) context.getApplication();
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

                                List<AllBean.DataBean.PublicSchoolsBean> schoolsBeans = dataBean.getPublic_schools();
                                if(null != schoolsBeans && schoolsBeans.size()>0){
                                    List<SchoolArea> schoolAreas = new ArrayList<>();
                                    for(AllBean.DataBean.PublicSchoolsBean schoolsBean : schoolsBeans){
                                        SchoolArea schoolArea = new SchoolArea();
                                        schoolArea.setBid(schoolsBean.getBid());
                                        schoolArea.setSchool_name(schoolsBean.getSchool_name());
                                        schoolAreas.add(schoolArea);
                                    }
                                    application.setSchoolAreas(schoolAreas);
                                }

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
                        }else {
                            onFailure(new Throwable(allBean.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                        LogUtils.d("GlobleAll===="+e.getMessage());
                    }
                });

        LoginService service = Http.getInstance().createRequest(LoginService.class);
        String dev_id = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        service.bindDevice(SpCache.getString(Config.UID,"0"),dev_id)
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean demo) {

                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
    }

    @Override
    public void onResume() {
       // Log.d(TAG1, "onResume: ");
    }

    @Override
    public void onPause() {
       // Log.d(TAG1, "onPause: ");
    }

    @Override
    public void onStop() {
        //Log.d(TAG1, "onStop: ");
    }

    @Override
    public void onDestroy() {
        //Log.d(TAG1, "onDestroy: ");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_home:
                mView.navigate(R.id.action_home);
                break;
            case R.id.item_study:
                mView.navigate(R.id.action_study);
                break;
            case R.id.item_zhibo:
                mView.navigateZhibo();
                break;
            case R.id.item_mine:
                mView.navigate(R.id.action_mine);
                break;
        }
        return true;
    }
}
