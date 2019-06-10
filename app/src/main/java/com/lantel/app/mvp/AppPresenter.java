package com.lantel.app.mvp;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lantel.MyApplication;
import com.lantel.app.api.AllBean;
import com.lantel.common.ClassRoom;
import com.lantel.common.SchoolArea;
import com.lantel.crmparent.R;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;
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
           /* case R.id.item_growup:
                mView.navigate(R.id.action_growup);
                break;*/
            case R.id.item_mine:
                mView.navigate(R.id.action_mine);
                break;
        }
        return true;
    }
}
