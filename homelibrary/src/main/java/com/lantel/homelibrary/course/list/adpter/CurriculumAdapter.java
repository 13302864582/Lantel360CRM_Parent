package com.lantel.homelibrary.course.list.adpter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.course.list.holder.CardCourseHolder;
import com.lantel.homelibrary.course.list.model.CourseItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.listview.listener.OnMenuClickListener;
import com.xiao360.baselibrary.util.DisplayUtil;

import java.util.List;

public class CurriculumAdapter extends BaseRecyclerViewAdapter<CourseItemModel> {
    private boolean isEdit = false;
    private boolean isAnimation = false;
    private OnClickDetailListener listener;

    public void setListener(OnClickDetailListener listener) {
        this.listener = listener;
    }

    public int getmLastPosition() {
        return mLastPosition;
    }

    private int mLastPosition = -1;

    public void setmLastPosition(int mLastPosition) {
        this.mLastPosition = mLastPosition;
    }

    public boolean toogleEdit() {
        isEdit = !isEdit;
        if(!isEdit)
            mLastPosition = -1;
        else {
            if(getItemCount()>0)
                mLastPosition = 0;
        }
        isAnimation = true;
        notifyDataSetChanged();
        return isEdit;
    }

    public boolean isAnimation() {
        return isAnimation;
    }

    public CurriculumAdapter(Context context, List<CourseItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.curriculum_item, parent, false);
        return new CardCourseHolder(view);
    }


    @Override
    protected void bindViewHolder(BaseViewHolder holder, CourseItemModel data, int position, int viewType) {
        CardCourseHolder card = (CardCourseHolder) holder;
        boolean isLeave = data.isLeave();
        setCheck(card, isLeave);
        card.teacher.setText(data.getTeacher());
        //card.room.setText(data.getClassRoom());
        card.imformation.setText(data.getSection());
        setText(data.getCourseName(), card.course_name);
        setText(data.getStartTime(), card.start_time);
        setText(data.getEndTime(), card.end_time);
        //setCheckLayout(isEdit, holder1);
        ObjectAnimator animator1 = null;

        ObjectAnimator animator2 = null;
        //TODO 动画暂时搁置，后期补，先完成功能
        //判断是否在动画中
        card.card.clearAnimation();
        card.check_layout.clearAnimation();
        //目前是编辑状态，开始收回动画
        animator1 = ObjectAnimator.ofFloat(card.card, "translationX", DisplayUtil.dip2px(isEdit && isLeave ? 50 : 0));
        animator2 = ObjectAnimator.ofFloat(card.check_layout, "translationX", DisplayUtil.dip2px(isEdit && isLeave ? 60 : -60));

        AnimatorSet set = new AnimatorSet();
        set.setDuration(isAnimation ? 500 : 0);
        set.playTogether(animator1, animator2);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                isAnimation = false;
            }
        });
        set.start();

        card.check.setChecked(mLastPosition == position);

        card.itemView.setOnClickListener((View view) -> {
            if(null != listener)
                listener.navigateDetail(data.getCa_id());
            int lastPosition = mLastPosition;
            if (position != mLastPosition) {
                mLastPosition = position;
                notifyItemChanged(lastPosition);
            }

            boolean state = card.check.isChecked();
            if (!state)
                card.check.setChecked(true);


        });

    }

    private void setCheck(CardCourseHolder holder1, boolean isLeave) {
        //true，未请假，false,请假了
        holder1.card.setEnabled(isLeave);
        holder1.ver_line.setEnabled(isLeave);
        holder1.start_time.setEnabled(isLeave);
        holder1.end_time.setEnabled(isLeave);
        holder1.class_name.setEnabled(isLeave);
        holder1.course_name.setEnabled(isLeave);

        int color = getColor(!isLeave ? R.color.img_text_unselect : R.color.img_text);
        holder1.room.setTextColor(color);
        holder1.teacher.setTextColor(color);
        holder1.imformation.setTextColor(color);

        holder1.room.setEnableImgText(isLeave);
        holder1.teacher.setEnableImgText(isLeave);
        holder1.imformation.setEnableImgText(isLeave);
        holder1.leave.setVisibility(!isLeave ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
