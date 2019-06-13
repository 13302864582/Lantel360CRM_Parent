package com.lantel.homelibrary.homework.mvp;

import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.homelibrary.homework.list.model.HomeWorkItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface HomeWorkContract {
    interface View extends BaseView {
        void refreshData(ArrayList<HomeWorkItemModel> menu);

        void setLoadMoreData(ArrayList<HomeWorkItemModel> menu);
    }

    abstract class Presenter<T,E> extends RefreshListFragmentPresenter<T,E,View, HomeWorkModel> {

    }
}
