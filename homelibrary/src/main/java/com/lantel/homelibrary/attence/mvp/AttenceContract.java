package com.lantel.homelibrary.attence.mvp;


import com.lantel.homelibrary.attence.list.model.AttenceCardModel;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface AttenceContract {
    interface View extends BaseView {
        void refreshData(ArrayList<AttenceCardModel> menu);

        void setLoadMoreData(ArrayList<AttenceCardModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, AttenceModel> {

    }
}
