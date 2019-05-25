package com.lantel.homelibrary.preview.mvp;

import com.lantel.homelibrary.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;
import java.util.ArrayList;

public interface PreviewContract {
    interface View extends BaseView {
        void initAttenceData(ArrayList<PreviewItemModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, PreviewModel> {

    }
}
