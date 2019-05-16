package com.lantel.homelibrary.output.mvp;
import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface OutputDetailContract {
    interface View extends BaseView {
        void initCourseData(BaseModel menu);
    }

    abstract class Presenter extends BaseActivityPresenter<View, OutputDetailModel> {

    }
}
