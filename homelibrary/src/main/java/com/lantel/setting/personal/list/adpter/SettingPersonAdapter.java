package com.lantel.setting.personal.list.adpter;


import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.personal.list.holder.SettingPersonHolder;
import com.lantel.setting.personal.list.model.SettingPersonItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SettingPersonAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    private int mCurrentPosition = -1;

    public void setListener(NaviEditListener listener) {
        this.listener = listener;
    }

    private NaviEditListener listener;
    public interface NaviEditListener{
        void editText(String editText);
    }


    public SettingPersonAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.setting_personal_item, parent, false);
        return new SettingPersonHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        SettingPersonHolder settingPersonHolder = (SettingPersonHolder) holder;
        SettingPersonItemModel model = (SettingPersonItemModel) data;
        setText(model.getTitle(),settingPersonHolder.title);

        if(viewType == Config.TYPE_SELECT_DATE){
            String date = getDateString(model.getValue());
            setText(date,settingPersonHolder.value);
        }else
        setText(model.getValue(),settingPersonHolder.value);

        settingPersonHolder.itemView.setOnClickListener((View view)-> {
            if(mCurrentPosition!=position)
                mCurrentPosition = position;
                navigateType(viewType);
        });
    }

    private void navigateType(int viewType) {
        switch (viewType){
            case Config.TYPE_EDIT_TEXT:
               if(listener!=null){
                   String editText = ((SettingPersonItemModel)datas.get(mCurrentPosition)).getValue();
                   listener.editText(editText);
               }
                break;
            case Config.TYPE_SELECT_TEXT:
                if(mCurrentPosition!=-1){
                    List<String> lis = Arrays.asList(((SettingPersonItemModel)datas.get(mCurrentPosition)).getStrs());
                    OptionsPickerView optionsPickerView = getOptionsPickerView(lis);
                    optionsPickerView.show();
                }

                break;
            case Config.TYPE_SELECT_DATE:
                getTimePickerView().show();
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    private String getDateString(String date) {
        String year = date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6);
        StringBuilder builder = new StringBuilder();
        builder.append(year).append("-").append(month).append("-").append(day);
        return builder.toString();
    }

    private TimePickerView getTimePickerView() {
        //时间选择器
        Calendar calendar = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        Resources resources = context.getResources();
        //正确设置方式 原因：注意事项有说明
        startDate.set(1993,0,1);
        endDate.set(2020,11,31);
        return new TimePickerBuilder(context,(Date date, View v)-> {
            // 格式化日期
            String value = (String) DateFormat.format("yyyyMMdd", date);
            notifyValue(value);
        })
                .setType(new boolean[]{true, true, true,false,false,false})//分别对应年月日时分秒，默认全部显示
                .setCancelText(getString(R.string.pickerview_cancel))//取消按钮文字
                .setCancelColor(resources.getColor(R.color.time_pick_btn))
                .setSubmitColor(resources.getColor(R.color.time_pick_btn))
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
                .build();
    }
    private OptionsPickerView getOptionsPickerView(List<String> options1Items) {
        String title = ((SettingPersonItemModel)datas.get(mCurrentPosition)).getTitle();
        Resources resources = context.getResources();
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(context,(int options1, int option2, int options3, View v)-> {
                //返回的分别是三个级别的选中位置
                notifyValue(options1Items.get(options1));
        })
                .setCancelText(getString(R.string.pickerview_cancel))//取消按钮文字
                .setCancelColor(resources.getColor(R.color.time_pick_btn))
                .setSubmitColor(resources.getColor(R.color.time_pick_btn))
                .setSubmitText(getString(R.string.pickerview_submit))//确认按钮文字
                .setContentTextSize(25)//滚轮文字大小
                .setTitleSize(28)//标题文字大小
                .setTitleText(title)//标题文字
                .build(); //切换时是否还原，设置默认选中第一项。;
        pvOptions.setPicker(options1Items);
        return pvOptions;
    }

    public void notifyValue(String value) {
        if(mCurrentPosition!=-1){
            ((SettingPersonItemModel)datas.get(mCurrentPosition)).setValue(value);
            notifyItemChanged(mCurrentPosition);
        }

    }
}
