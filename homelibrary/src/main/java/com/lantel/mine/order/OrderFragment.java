package com.lantel.mine.order;

import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.mine.order.list.adpter.OrderAdapter;
import com.lantel.mine.order.list.model.OrderItemModel;
import com.lantel.mine.order.mvp.OrderContract;
import com.lantel.mine.order.mvp.OrderModel;
import com.lantel.mine.order.mvp.OrderPresenter;
import com.xiao360.baselibrary.base.NormalListFragment;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class OrderFragment extends NormalListFragment<OrderPresenter, OrderModel> implements OrderContract.View {
    @Override
    protected void InitView() {
        ArrayList list = new ArrayList();
        for(int i=0;i<20;i++){
            list.add(new OrderItemModel());
        }
        OrderAdapter adapter = (OrderAdapter) mAdapter;
        adapter.setDatas(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getListView() {
        return R.id.recyclerView;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new OrderAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.order;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.common_list_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected OrderModel getModel() {
        return FindModel(OrderModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void showFail() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }
}
