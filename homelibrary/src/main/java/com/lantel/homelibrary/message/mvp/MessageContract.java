package com.lantel.homelibrary.message.mvp;
import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.homelibrary.message.list.model.MessageItemModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface MessageContract {
    interface View extends BaseView {
        void refreshData(ArrayList<MessageItemModel> menu);

        void setLoadMoreData(ArrayList<MessageItemModel> menu);
    }

    abstract class Presenter<T,E> extends RefreshListFragmentPresenter<T,E,View, MessageModel> {

    }
}
