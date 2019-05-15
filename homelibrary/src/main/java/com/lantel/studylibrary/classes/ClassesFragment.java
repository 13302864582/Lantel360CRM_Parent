package com.lantel.studylibrary.classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lantel.homelibrary.R;
import com.lantel.studylibrary.classes.list.adpter.ClassesAdapter;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.lantel.studylibrary.classes.mvp.ClassesContract;
import com.lantel.studylibrary.classes.mvp.ClassesModel;
import com.lantel.studylibrary.classes.mvp.ClassesPresenter;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class ClassesFragment extends ToolBarStateFragment<ClassesPresenter, ClassesModel> implements ClassesContract.View{
   /* @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.filter_date)
    ImageView filterDate;
    @BindView(R.id.attence_list)
    RecyclerView classesList;
    private ClassesAdapter mAdapter;*/

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
        return R.layout.classes_content;
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
    protected ClassesModel getModel() {
        return FindModel(ClassesModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
       // filterDate.setVisibility(View.GONE);
      /*  classesList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ClassesAdapter(getContext(),null);
        classesList.setAdapter(mAdapter);*/
    }

    @Override
    public void initAttenceData(ArrayList<ClassesCardModel> menu) {
       // mAdapter.setDatas(menu);
       // mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.back, R.id.filter_date})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){

        }
    }


}
