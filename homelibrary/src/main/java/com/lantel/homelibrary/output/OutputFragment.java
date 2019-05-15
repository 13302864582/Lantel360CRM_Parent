package com.lantel.homelibrary.output;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.course.list.adpter.CurriculumAdapter;
import com.lantel.homelibrary.course.mvp.CourseContract;
import com.lantel.homelibrary.course.mvp.CoursePresenter;
import com.lantel.homelibrary.output.list.adpter.OutputAdapter;
import com.lantel.homelibrary.output.mvp.OutputContract;
import com.lantel.homelibrary.output.mvp.OutputModel;
import com.lantel.homelibrary.output.mvp.OutputPresenter;
import com.lantel.studylibrary.course.list.adpter.CourseAdapter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.OnClick;

public class OutputFragment extends ToolBarStateFragment<OutputPresenter, OutputModel> implements OutputContract.View {
    private OutputAdapter mAdapter;

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
        return R.layout.ouput_content;
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
    protected OutputModel getModel() {
        return FindModel(OutputModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        classes_list.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CourseAdapter(getContext(),null);
        classes_list.setAdapter(mAdapter);
    }

    @Override
    public void initCourseData(ArrayList<BaseModel> menu) {

    }
}
