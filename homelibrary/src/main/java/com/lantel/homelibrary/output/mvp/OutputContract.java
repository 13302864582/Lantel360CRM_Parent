package com.lantel.homelibrary.output.mvp;


import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface OutputContract {
    interface View extends BaseView {
        void initCourseData(ArrayList<BaseModel> menu);

        void refreshData(ArrayList<BaseModel> menu);

        void setLoadMoreData(ArrayList<BaseModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, OutputModel> {

    }
}
