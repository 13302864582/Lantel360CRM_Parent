package com.lantel.setting.bindfile.bindstudent.mvp;

import com.lantel.common.HttpResBean;
import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface BindStudentContract {
    interface View extends BaseView {
        void refreshData(ArrayList<BindStudentListModel> menu);

        void setLoadMoreData(ArrayList<BindStudentListModel> menu);
    }

    abstract class Presenter<T extends HttpResBean,E> extends RefreshListFragmentPresenter<T,E,View, BindStudentModel> {

    }
}
