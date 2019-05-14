package com.lantel.homelibrary.course.mvp;


import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface CourseContract {
    interface View extends BaseView {
        void initCourseData(ArrayList<BaseModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, CourseModel> {

    }
}
