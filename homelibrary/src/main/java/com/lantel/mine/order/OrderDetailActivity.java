package com.lantel.mine.order;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.order.api.OrderDetailBean;
import com.lantel.mine.order.list.adpter.OrderDetailAdapter;
import com.lantel.mine.order.list.model.DetailEndModel;
import com.lantel.mine.order.list.model.DetailListModel;
import com.lantel.mine.order.list.model.DetailTopModel;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/order/detail")
public class OrderDetailActivity extends BaseActivity {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.attence_list)
    RecyclerView mList;

    private OrderDetailAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.notify_layout;
    }

    @Override
    public void initView() {
        title.setText(getString(R.string.order_detail));
        String orderDetail = getIntent().getStringExtra(Config.ORDER_DETAIL);
        OrderDetailBean detailBean = new Gson().fromJson(orderDetail,OrderDetailBean.class);
        ArrayList<BaseModel> list = new ArrayList<>();
        list.add(getTopModel(detailBean));
        list.addAll(getListModel(detailBean.getOrder_items()));
        list.add(getEndModel(detailBean));
        mAdapter = new OrderDetailAdapter(this,list);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(mAdapter);
    }

    private DetailEndModel getEndModel(OrderDetailBean detailBean) {
        DetailEndModel model = new DetailEndModel();
        model.setMoney(getFormatString(R.string.money_formate,getMoney(detailBean.getPaid_amount()),"0.00"));
        return model;
    }

    private ArrayList<DetailListModel> getListModel(List<OrderDetailBean.OrderItemsBean> order_items) {
        ArrayList<DetailListModel> list = new ArrayList<>();
        for(OrderDetailBean.OrderItemsBean orderItemsBean : order_items){
            DetailListModel model = new DetailListModel();
            if(null!=orderItemsBean.getLesson())
            model.setList_img(orderItemsBean.getLesson().getLesson_cover_picture());
            model.setList_title(orderItemsBean.getItem_name());
            model.setCourse_time(getFormatString(R.string.course_formate,orderItemsBean.getNums(),"0"));
            model.setUseful_date(getFormatString(R.string.useful_date_formate,orderItemsBean.getExpire_time(),"-"));
            model.setPaid_money(getMoney(orderItemsBean.getSubtotal()));
            model.setOrigin_price(getMoney(orderItemsBean.getOrigin_price()));
            model.setPrice(getMoney(orderItemsBean.getPrice()));
            model.setDiscount_amount(getMoney(orderItemsBean.getDiscount_amount()));
            model.setReduced_amount(getMoney(orderItemsBean.getReduced_amount()));
            model.setPresent_times(orderItemsBean.getPresent_lesson_hours());
            list.add(model);
        }
        return list;
    }

    public String getMoney(String money) {
        return DisplayUtil.formatNum(String.format("¥%.2f",Float.valueOf(money)));
    }

    public String getFormatString(int format,String str,String def) {
        return String.format(getString(format),TextUtils.isEmpty(str)?def:str);
    }

    public DetailTopModel getTopModel(OrderDetailBean detailBean) {
        DetailTopModel topModel = new DetailTopModel();
        topModel.setOrder_id(getFormatString(R.string.order_no_format,detailBean.getOrder_no(),""));
        topModel.setJoin_time(getFormatString(R.string.join_time_format,detailBean.getCreate_time(),""));
        topModel.setOrder_time(getFormatString(R.string.order_time_format,detailBean.getPaid_time(),""));
        return topModel;
    }

    @OnClick(R2.id.back)
    public void onViewClicked(View v) {
        if(v.getId() == R.id.back)
            finish();
    }
}
