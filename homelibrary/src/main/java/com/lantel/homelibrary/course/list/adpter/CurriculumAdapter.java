package com.lantel.homelibrary.course.list.adpter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.course.list.holder.CardCourseHolder;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;
import com.xiao360.baselibrary.util.DisplayUtil;
import java.util.List;

public class CurriculumAdapter extends BaseRecyclerViewAdapter {
    private boolean isEdit = false;
    private boolean isAnimation = false;
    private int mLastPosition = -1;

    public boolean toogleEdit() {
        isEdit = !isEdit;
        isAnimation = true;
        notifyDataSetChanged();
        return isEdit;
    }

    public boolean isAnimation() {
        return isAnimation;
    }

    public CurriculumAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.curriculum_item, parent, false);
        return new CardCourseHolder(view);
    }



    @Override
    protected void bindViewHolder(BaseViewHolder holder, Object data, int position, int viewType) {
        CardCourseHolder holder1 = (CardCourseHolder) holder;
        BaseModel baseModel = (BaseModel) data;
        boolean isLeave = baseModel.getType() == 0;
        setCheck(holder1,isLeave);
        //setCheckLayout(isEdit, holder1);
        ObjectAnimator animator1 = null;

        ObjectAnimator animator2 = null;
        //TODO 动画暂时搁置，后期补，先完成功能
        //判断是否在动画中
            holder1.card.clearAnimation();
            holder1.check_layout.clearAnimation();
            //目前是编辑状态，开始收回动画
            animator1 = ObjectAnimator.ofFloat(holder1.card, "translationX", DisplayUtil.dip2px(isEdit&&isLeave?50:0));
            animator2 = ObjectAnimator.ofFloat(holder1.check_layout, "translationX", DisplayUtil.dip2px(isEdit&&isLeave?60:-60));

            AnimatorSet set = new AnimatorSet();
            set.setDuration(isAnimation?500:0);
            set.playTogether(animator1, animator2);
            set.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    isAnimation = false;
                }
            });
            set.start();

        holder1.check.setChecked(mLastPosition == position);

        holder1.itemView.setOnClickListener((View view) -> {
            int lastPosition = mLastPosition;
            if(position != mLastPosition){
                mLastPosition = position;
                notifyItemChanged(lastPosition);
            }

            boolean state = holder1.check.isChecked();
            if(!state)
                holder1.check.setChecked(true);

        });

    }

    private void setCheck(CardCourseHolder holder1, boolean isLeave) {
        holder1.card.setEnabled(isLeave);
        holder1.ver_line.setEnabled(isLeave);
        holder1.start_time.setEnabled(isLeave);
        holder1.end_time.setEnabled(isLeave);
        holder1.class_name.setEnabled(isLeave);
        holder1.course_name.setEnabled(isLeave);

        int color = getColor(!isLeave?R.color.img_text_unselect:R.color.img_text);
        holder1.room.setTextColor(color);
        holder1.teacher.setTextColor(color);
        holder1.imformation.setTextColor(color);

        holder1.room.setEnableImgText(isLeave);
        holder1.teacher.setEnableImgText(isLeave);
        holder1.imformation.setEnableImgText(isLeave);
        holder1.leave.setVisibility(!isLeave?View.VISIBLE:View.INVISIBLE);
    }

    @Override
    public int getItemViewType(int position) {
        return ((BaseModel)datas.get(position)).getType();
    }
}
