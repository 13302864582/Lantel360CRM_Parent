package com.lantel.homelibrary.course;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.course.list.adpter.CurriculumAdapter;
import com.lantel.homelibrary.course.mvp.CourseContract;
import com.lantel.homelibrary.course.mvp.CourseModel;
import com.lantel.homelibrary.course.mvp.CoursePresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import java.util.ArrayList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class CourseFragment extends ToolBarStateFragment<CoursePresenter, CourseModel> implements CourseContract.View , CalendarView.OnCalendarSelectListener {
    @BindView(R2.id.course_list)
    RecyclerView mCourseList;
    @BindView(R2.id.sick_leave)
    RadioButton sickLeave;
    @BindView(R2.id.casual_leave)
    RadioButton casualLeave;
    @BindView(R2.id.leave_radioGroup)
    RadioGroup leaveRadioGroup;
    @BindView(R2.id.ok_btn)
    Button okBtn;
    @BindView(R2.id.course_bottom_select)
    ConstraintLayout courseBottomSelect;
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.leave)
    TextView leave;
    @BindView(R2.id.course_top)
    LinearLayout courseTop;
    @BindView(R2.id.calendarView)
    CalendarView calendarView;
    private CurriculumAdapter mAdapter;
    private LinearLayoutManager mLineManager;

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
        return R.layout.course_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.course_toolbar;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected CourseModel getModel() {
        return FindModel(CourseModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        calendarView.setOnCalendarSelectListener(this);
    }

    @OnClick({R2.id.back, R2.id.leave, R2.id.ok_btn})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            getActivity().finish();
        } else if (id == R.id.leave) {
            if (mAdapter != null) {
                if (!mAdapter.isAnimation()) {
                    boolean state = mAdapter.toogleEdit();
                    toogleBottomMenu(state);
                }
            }
        } else if (id == R.id.ok_btn) {

        }
    }

    private void toogleBottomMenu(boolean state) {
        leave.setText(getString(state ? R.string.cancel : R.string.leave));
        // 组合动画设置
        Animation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_SELF, state ? 1 : 0, Animation.RELATIVE_TO_SELF, state ? 0 : 1);
        // 创建平移动画的对象：平移动画对应的Animation子类为TranslateAnimation
        translateAnimation.setDuration(300);
        // 播放动画直接 startAnimation(translateAnimation)
        //如：
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (state)
                    courseBottomSelect.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!state)
                    courseBottomSelect.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        courseBottomSelect.startAnimation(translateAnimation);
    }

    @Override
    public void initCourseData(ArrayList<BaseModel> menu) {
        mLineManager = new LinearLayoutManager(getContext());
        mCourseList.setLayoutManager(mLineManager);
        mAdapter = new CurriculumAdapter(getContext(), menu);
        mCourseList.setAdapter(mAdapter);
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {

    }
}
