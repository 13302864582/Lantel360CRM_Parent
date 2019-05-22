package com.lantel.homelibrary.accessment.mvp;


import com.lantel.homelibrary.accessment.list.model.AccessItemModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface AccessContract {
    interface View extends BaseView {
        void initAttenceData(ArrayList<AccessItemModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, AccessModel> {

    }
}
