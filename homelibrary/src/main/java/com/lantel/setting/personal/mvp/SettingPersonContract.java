package com.lantel.setting.personal.mvp;


import com.lantel.setting.personal.list.model.SettingPersonItemModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface SettingPersonContract {
    interface View extends BaseView {
        void initList(ArrayList<SettingPersonItemModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, SettingPersonModel> {

    }
}
