package com.lantel.homelibrary.output.mvp;


import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface OutputContract {
    interface View extends BaseView {
        void initCourseData(ArrayList<BaseModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, OutputModel> {

    }
}
