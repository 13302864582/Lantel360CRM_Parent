package com.lantel.studylibrary.course.fragment;

import android.view.View;
import android.widget.ImageView;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.studylibrary.course.list.adpter.CourseAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.ToolBarStateFragment;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public abstract class BaseCourseFragment<T extends BaseFragmentPresenter, E extends ViewModel> extends ToolBarStateFragment<T, E> {
    protected CourseAdapter mAdapter;
    @BindView(R2.id.refreshlayout)
    SmartRefreshLayout refreshlayout;
    @BindView(R2.id.classes_list)
    RecyclerView classes_list;
    @BindView(R2.id.empty_img)
    ImageView emptyImg;

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
        return R.layout.classes_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return -1;
    }

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        emptyImg.setImageResource(R.mipmap.empty_course);
        classes_list = rootView.findViewById(R.id.classes_list);
        classes_list.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CourseAdapter(getContext(), null);
        classes_list.setAdapter(mAdapter);
    }
}
