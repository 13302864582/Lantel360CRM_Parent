package com.lantel.homelibrary.classreview.mvp;


import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface ClassReviewContract {
    interface View extends BaseView {
        void refreshData(ArrayList<ClassReviewCardModel> menu);

        void setLoadMoreData(ArrayList<ClassReviewCardModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, ClassReviewModel> {

    }
}
