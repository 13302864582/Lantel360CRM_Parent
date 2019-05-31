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
import com.lantel.homelibrary.course.list.model.CourseItemModel;
import com.lantel.homelibrary.course.mvp.CourseContract;
import com.lantel.homelibrary.course.mvp.CourseModel;
import com.lantel.homelibrary.course.mvp.CoursePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.ToastUitl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.internal.Util;

public class CourseFragment extends ToolBarStateFragment<CoursePresenter, CourseModel> implements CourseContract.View , CalendarView.OnCalendarSelectListener, OnRefreshLoadMoreListener {
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
    @BindView(R2.id.month)
    TextView month;
    @BindView(R2.id.course_bottom_select)
    ConstraintLayout courseBottomSelect;
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.text_right)
    TextView text_right;
    @BindView(R2.id.course_top)
    LinearLayout courseTop;
    @BindView(R2.id.calendarView)
    CalendarView calendarView;

    private CurriculumAdapter curriculumAdapter;
    private LinearLayoutManager mLineManager;
    private boolean hasLoadMore = false;
    private boolean isBeforeToday = false;

    @Override
    protected int getContainerLayoutID() {
        return R.layout.common_container;
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
        text_right.setText(R.string.leave);
        calendarView.setOnCalendarSelectListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mCourseList.setLayoutManager(manager);
        curriculumAdapter = new CurriculumAdapter(getContext(),null);
        mCourseList.setAdapter(curriculumAdapter);
        stateLayout.refreshLayout.setOnRefreshLoadMoreListener(this);
        stateLayout.refreshLayout.setEnableLoadMore(false);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        month.setText(String.format(getString(R.string.month_format),calendar.get(java.util.Calendar.MONTH)+1));
        mCourseList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisible = manager.findLastVisibleItemPosition();
                if(!hasLoadMore && lastVisible>=9){
                    stateLayout.refreshLayout.setEnableLoadMore(true);
                    hasLoadMore = true;
                }
            }
        });
    }

    @OnClick({R2.id.back, R2.id.text_right, R2.id.ok_btn})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            getActivity().finish();
        } else if (id == R.id.text_right) {
            if (curriculumAdapter != null) {
                if (!curriculumAdapter.isAnimation()) {
                    boolean state = curriculumAdapter.toogleEdit();
                    toogleBottomMenu(state);
                }
            }
        } else if (id == R.id.ok_btn) {
            int checkID = leaveRadioGroup.getCheckedRadioButtonId();
        }
    }

    private void toogleBottomMenu(boolean state) {
        text_right.setText(getString(state ? R.string.cancel : R.string.leave));
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
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        if(isClick){
            int today = Integer.valueOf(DisplayUtil.praseformatIntDay("yyyyMMdd",new Date(System.currentTimeMillis())));
            int selectDay = Integer.valueOf(calendar.toString());
            isBeforeToday = (selectDay-today)<0;
            if(isBeforeToday)
                text_right.setVisibility(View.GONE);
        }
        month.setText(String.format(getString(R.string.month_format),calendar.getMonth()));
        mPresenter.onCalendarSelect(calendar,isClick);
    }

    @Override
    public void showEmpty() {
        stateLayout.showEmptyView();
    }

    @Override
    public void showLoading() {
        stateLayout.showLoadingView();
    }

    @Override
    public void showNetWorkError() {
        stateLayout.showFailView();
    }

    @Override
    public void setSchemeDate(Map<String, Calendar> mSchemeDates) {
        calendarView.setSchemeDate(mSchemeDates);
    }

    public void refreshData(ArrayList<CourseItemModel> menu) {
        if(menu.size()!=0){
            stateLayout.showContentView();
            curriculumAdapter.setmLastPosition(0);
            if(!isBeforeToday)
            text_right.setVisibility(View.VISIBLE);
        } else{
            stateLayout.showEmptyView();
            text_right.setVisibility(View.GONE);
        }

        curriculumAdapter.setDatas(menu);
        curriculumAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadMoreData(ArrayList<CourseItemModel> menu) {
        int start = curriculumAdapter.getDatas().size();
        curriculumAdapter.getDatas().addAll(menu);
        curriculumAdapter.notifyItemRangeInserted(start,menu.size());
        curriculumAdapter.notifyItemRangeChanged(start,menu.size());
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPresenter.onLoadMore(refreshLayout);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.refreshData(refreshLayout);
    }
}
