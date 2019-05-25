package com.lantel.homelibrary.classreview;

import android.view.View;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.classreview.list.adpter.ClassReviewAdapter;
import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.lantel.homelibrary.classreview.mvp.ClassReviewContract;
import com.lantel.homelibrary.classreview.mvp.ClassReviewModel;
import com.lantel.homelibrary.classreview.mvp.ClassReviewPresenter;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class ClassReviewFragment extends NormalListFragment<ClassReviewPresenter, ClassReviewModel> implements ClassReviewContract.View{
    @Override
    protected void InitView() {

    }

    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ClassReviewAdapter(getContext(),null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.class_review;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.attence_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected ClassReviewModel getModel() {
        return FindModel(ClassReviewModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initAttenceData(ArrayList<ClassReviewCardModel> menu) {
        ((ClassReviewAdapter)mAdapter).setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFail() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }
}
