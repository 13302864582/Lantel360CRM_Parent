package com.lantel.studylibrary.classes.mvp;


import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface ClassesContract {
    interface View extends BaseView {
        void setData(ArrayList<ClassesCardModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, ClassesModel> {

    }
}
