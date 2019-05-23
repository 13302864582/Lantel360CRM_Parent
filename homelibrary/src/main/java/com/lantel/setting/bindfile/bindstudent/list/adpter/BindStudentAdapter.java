package com.lantel.setting.bindfile.bindstudent.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;
import com.lantel.homelibrary.R;
import com.lantel.setting.bindfile.bindstudent.list.holder.BindStudentHolder;
import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.List;

public class BindStudentAdapter extends BaseRecyclerViewAdapter<BindStudentListModel> {
    private NormalDialog unBindDialog;

    public BindStudentAdapter(Context context, List<BindStudentListModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bind_student_item, parent, false);
        return new BindStudentHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BindStudentListModel data, int position, int viewType) {
        BindStudentHolder classesHolder = (BindStudentHolder) holder;
        setText(data.getName(),classesHolder.name);
        setText(data.getAge(),classesHolder.age);
        setText(data.getClass_room(),classesHolder.classes_room);
        setText(data.getClass_area(),classesHolder.classes_area);
        setText(getString(data.isBind()?R.string.bind:R.string.unbind_yet),classesHolder.bind_text);
        classesHolder.bind_img.setSelected(data.isBind());

        classesHolder.bind_img.setOnClickListener((View view)-> {
            String sAgeFormat1= context.getResources().getString(R.string.bind_tip);
            String sFinal1 = String.format(sAgeFormat1, data.getName());
            unBindDialog = new NormalDialog(context);
            unBindDialog.widthScale(0.75f);
            unBindDialog.setCanceledOnTouchOutside(false);
            unBindDialog.btnText(getString(R.string.confirm_sure),getString(R.string.cancel));
            unBindDialog.title(getString(R.string.cancel_bind));
            unBindDialog.content(sFinal1);
            unBindDialog.style(NormalDialog.STYLE_TWO);
            unBindDialog.titleTextColor(R.color.black);
            unBindDialog.contentTextColor(context.getResources().getColor(R.color.dialog_content));
            unBindDialog.setOnBtnClickL(new OnBtnClickL[]{
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            datas.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据
                            unBindDialog.dismiss();
                        }
                    },new OnBtnClickL() {
                @Override
                public void onBtnClick() {
                    unBindDialog.dismiss();
                }
            }
            });
            unBindDialog.show();
        });
        GlideUtils.loadImageView(context,data.getHeaImg(),classesHolder.head_img);
    }
}
