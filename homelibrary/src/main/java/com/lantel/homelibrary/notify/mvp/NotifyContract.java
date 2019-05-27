package com.lantel.homelibrary.notify.mvp;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface NotifyContract {
    interface View extends BaseView {
        void refreshData(ArrayList<NotifyItemModel> menu);

        void setLoadMoreData(ArrayList<NotifyItemModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, NotifyModel> {

    }
}
