package com.lantel.setting.bindfile.mvp;


import com.lantel.common.list.model.SimpleMenuModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface BindFileContract {
    interface View extends BaseView {
        void initList(ArrayList<SimpleMenuModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, BindFileModel> {

    }
}
