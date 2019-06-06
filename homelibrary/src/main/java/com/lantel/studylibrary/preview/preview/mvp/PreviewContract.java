package com.lantel.studylibrary.preview.preview.mvp;

import com.lantel.common.RefreshListFragmentPresenter;
import com.lantel.studylibrary.preview.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.mvp.BaseView;
import java.util.ArrayList;

public interface PreviewContract {
    interface View extends BaseView {
        void refreshData(ArrayList<PreviewItemModel> menu);

        void setLoadMoreData(ArrayList<PreviewItemModel> menu);
    }

    abstract class Presenter<T,E> extends RefreshListFragmentPresenter<T,E,View, PreviewModel> {

    }
}
