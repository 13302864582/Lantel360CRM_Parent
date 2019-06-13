package com.lantel.homelibrary.homework;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.lantel.homelibrary.homework.list.model.HomeWorkItemModel;
import com.lantel.homelibrary.homework.mvp.HomeWorkContract;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import java.util.ArrayList;
import androidx.lifecycle.ViewModel;

@Route(path = "/lantel/360/homework/detail")
public class HomeWorkDetailActivity extends BaseMVPActivity implements HomeWorkContract.View {

    @Override
    public void refreshData(ArrayList<HomeWorkItemModel> menu) {

    }

    @Override
    public void setLoadMoreData(ArrayList<HomeWorkItemModel> menu) {

    }

    @Override
    protected BarHide hideBar() {
        return null;
    }

    @Override
    protected int getStateBarviewID() {
        return 0;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }
}
