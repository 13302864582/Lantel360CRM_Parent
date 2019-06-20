package com.lantel.homelibrary.communicate.mvp;

import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.homelibrary.communicate.list.model.ItemModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

import androidx.collection.ArraySet;

public interface CommunicateContract {
    interface View extends BaseView {
        void refreshData(ArrayList<ItemModel> menu);

        void setLoadMoreData(ArrayList<ItemModel> menu);

        int getItemCount();
    }

    abstract class Presenter<T,E> extends RefreshListFragmentPresenter<T,E,View, com.lantel.homelibrary.communicate.mvp.CommunicateModel> {

    }
}
