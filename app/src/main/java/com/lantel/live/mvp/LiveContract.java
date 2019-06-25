package com.lantel.live.mvp;

import com.lantel.common.HttpResBean;
import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.live.list.model.LiveCardModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface LiveContract {
    interface View extends BaseView {
        void refreshData(ArrayList<LiveCardModel> menu);

        void setLoadMoreData(ArrayList<LiveCardModel> menu);
    }

    abstract class Presenter<T extends HttpResBean,E> extends RefreshListFragmentPresenter<T,E,View, LiveModel> {

    }
}
