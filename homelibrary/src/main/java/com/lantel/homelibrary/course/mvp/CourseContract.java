package com.lantel.homelibrary.course.mvp;


import com.haibin.calendarview.Calendar;
import com.lantel.homelibrary.course.list.model.CourseItemModel;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;
import java.util.Map;

public interface CourseContract {
    interface View extends BaseView {
        void setSchemeDate(Map<String, Calendar> mSchemeDates);

        void refreshData(ArrayList<CourseItemModel> menu);

        void setLoadMoreData(ArrayList<CourseItemModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, CourseModel> {

    }
}
