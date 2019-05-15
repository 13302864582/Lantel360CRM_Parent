package com.lantel.studylibrary.course.mvp.reading;


import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface ReadingContract {
    interface View extends BaseView {
        void initData(ArrayList<CourseCardModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, ReadingModel> {

    }
}
