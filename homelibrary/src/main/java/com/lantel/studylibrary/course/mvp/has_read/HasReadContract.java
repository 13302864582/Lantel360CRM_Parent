package com.lantel.studylibrary.course.mvp.has_read;


import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface HasReadContract {
    interface View extends BaseView {
        void initAttenceData(ArrayList<CourseCardModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, HasReadModel> {

    }
}
