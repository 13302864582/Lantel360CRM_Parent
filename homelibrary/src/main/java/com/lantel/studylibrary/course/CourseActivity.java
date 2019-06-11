package com.lantel.studylibrary.course;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.studylibrary.course.fragment.BaseCourseFragment;
import com.lantel.studylibrary.course.fragment.HasReadFrag;
import com.lantel.studylibrary.course.fragment.PlanReadFrag;
import com.lantel.studylibrary.course.fragment.ReadingFrag;
import com.xiao360.baselibrary.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/course")
public class CourseActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    @BindView(R2.id.tab_top)
    TabLayout tabTop;
    @BindView(R2.id.pager)
    ViewPager mViewPager;

    private CourseFragmentPagerAdapter mAdapter;
    private String[] titles;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_course;
    }

    @Override
    public void initView() {
        initTab();
        setupWithViewPager();
        title.setText(R.string.course);
    }

    private void initTab() {
        titles = getResources().getStringArray(R.array.course_page_title);
        for (int i = 0; i < titles.length; i++) {
           tabTop.addTab(tabTop.newTab().setText(titles[i]));
       }
        tabTop.addOnTabSelectedListener(this);
    }

    /**
     * Description：初始化FragmentPagerAdapter适配器并给ViewPager设置上该适配器，最后关联TabLayout和ViewPager
     */
    private void setupWithViewPager() {
        List<BaseCourseFragment> mFragments = new ArrayList<>();
        mFragments.add(new ReadingFrag());
        mFragments.add(new HasReadFrag());
        mFragments.add(new PlanReadFrag());
        mAdapter = new CourseFragmentPagerAdapter(getSupportFragmentManager());
        mAdapter.addTitlesAndFragments(titles, mFragments);
        mViewPager.setAdapter(mAdapter); // 给ViewPager设置适配器
        mViewPager.setOffscreenPageLimit(2);
        tabTop.setupWithViewPager(mViewPager); //关联TabLayout和ViewPager
    }

    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
            finish();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
