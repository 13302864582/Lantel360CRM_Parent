package com.lantel.homelibrary.output.mvp;


import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface OutputContract {
    interface View extends BaseView {
        void refreshData(ArrayList<CardOutputModel> menu);

        void setLoadMoreData(ArrayList<CardOutputModel> menu);
    }

    abstract class Presenter<T,E> extends RefreshListFragmentPresenter<T,E,View, OutputModel> {

    }
}
