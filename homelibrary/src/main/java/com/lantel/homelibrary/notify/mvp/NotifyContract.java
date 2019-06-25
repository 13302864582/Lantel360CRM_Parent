package com.lantel.homelibrary.notify.mvp;

import com.lantel.common.HttpResBean;
import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface NotifyContract {
    interface View extends BaseView {
        void refreshData(ArrayList<NotifyItemModel> menu);

        void setLoadMoreData(ArrayList<NotifyItemModel> menu);
    }

    abstract class Presenter<T extends HttpResBean,E> extends RefreshListFragmentPresenter<T,E,View, NotifyModel> {

    }
}
