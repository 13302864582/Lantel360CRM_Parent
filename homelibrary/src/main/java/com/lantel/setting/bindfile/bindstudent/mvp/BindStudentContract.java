package com.lantel.setting.bindfile.bindstudent.mvp;


import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface BindStudentContract {
    interface View extends BaseView {
        void initAttenceData(ArrayList<BindStudentListModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, BindStudentModel> {

    }
}
