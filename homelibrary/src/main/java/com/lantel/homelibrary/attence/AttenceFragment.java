package com.lantel.homelibrary.attence;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.attence.list.adpter.AttenceAdapter;
import com.lantel.homelibrary.attence.list.model.AttenceCardModel;
import com.lantel.homelibrary.attence.mvp.AttenceContract;
import com.lantel.homelibrary.attence.mvp.AttenceModel;
import com.lantel.homelibrary.attence.mvp.AttencePresenter;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class AttenceFragment extends ToolBarStateFragment<AttencePresenter, AttenceModel> implements AttenceContract.View, OnTimeSelectListener {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    @BindView(R2.id.attence_list)
    RecyclerView attenceList;
    private AttenceAdapter mAdapter;

    @Override
    protected int getContainerLayoutID() {
        return R.layout.course_container;
    }

    @Override
    protected int getFailViewId() {
        return R.id.fail;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.loading;
    }

    @Override
    protected int getEmptyViewId() {
        return R.id.empty;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.attence_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.attence_toolbar;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected AttenceModel getModel() {
        return FindModel(AttenceModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    protected void initView() {
        stateLayout.showContentView();
        attenceList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AttenceAdapter(getContext(),null);
        attenceList.setAdapter(mAdapter);
    }

    @Override
    public void initAttenceData(ArrayList<AttenceCardModel> menu) {
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R2.id.back, R2.id.filter_date})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.filter_date) {
//时间选择器
            Calendar calendar = Calendar.getInstance();
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();

            //正确设置方式 原因：注意事项有说明
            startDate.set(1993,0,1);
            endDate.set(2020,11,31);
            TimePickerView timePicker = new TimePickerBuilder(getContext(),this)
                    .setType(new boolean[]{true, true, false,false,false,false})//分别对应年月日时分秒，默认全部显示
                    .setCancelText(getString(R.string.pickerview_cancel))//取消按钮文字
                    .setCancelColor(getResColor(R.color.time_pick_btn))
                    .setSubmitColor(getResColor(R.color.time_pick_btn))
                    .setSubmitText(getString(R.string.pickerview_submit))//确认按钮文字
                    .setContentTextSize(25)//滚轮文字大小
                    .setTitleSize(28)//标题文字大小
                    .setTitleText(getString(R.string.select_time))//标题文字
                    .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                    .isCyclic(true)//是否循环滚动
                    .setDate(calendar)
                    .setRangDate(startDate,endDate)
                    .setLabel("年","月","日","时","分","秒")
                    .isDialog(false)
                    .build();//是否显示为对话框样式
            timePicker.show();
        } else if(id == R.id.back){

        }
    }

    @Override
    public void onTimeSelect(Date date, View v) {
        LogUtils.d("onTimeSelect==="+date.toString());
    }
}
