package com.lantel.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.mine.list.adpter.mineCardListApater;
import com.lantel.mine.list.adpter.mineMenuListApater;
import com.lantel.mine.mvp.MineContract;
import com.lantel.mine.mvp.MineModel;
import com.lantel.mine.mvp.MinePresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends ToolBarStateFragment<MinePresenter, MineModel> implements MineContract.View, OnActionPathListener {
    @BindView(R.id.statebarView)
    View statebarView;
    @BindView(R.id.top_img_right)
    ImageView topImgRight;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.mine_head_img)
    ImageView mineHeadImg;
    @BindView(R.id.toolbar)
    ConstraintLayout toolbar;
    @BindView(R.id.mine_name)
    TextView mineName;
    @BindView(R.id.mine_call)
    TextView mineCall;
    @BindView(R.id.mine_age)
    TextView mineAge;
    @BindView(R.id.mine_student_id)
    TextView mineStudentId;
    @BindView(R.id.mine_card_id)
    TextView mineCardId;
    @BindView(R.id.mine_card_list)
    RecyclerView mineCardList;
    @BindView(R.id.mine_menu_list)
    RecyclerView mineMenuList;

    private mineCardListApater mCardListApater;
    private mineMenuListApater mMenuListApater;

    @Override
    public void notifyCardData(ArrayList<BaseModel> list) {
        mCardListApater.setDatas(list);
        mCardListApater.notifyDataSetChanged();
    }

    @Override
    public void notifyMenuData(ArrayList<SimpleMenuModel> list) {
        mMenuListApater.setDatas(list);
        mMenuListApater.notifyDataSetChanged();
    }

    @Override
    public void loadCircleHeadImage(String url) {
        GlideUtils.loadCircle(getContext(),url,mineHeadImg,R.mipmap.circle_default);
    }

    @Override
    public void initCardData(String[] titles) {
        mineCardList.setLayoutManager(new GridLayoutManager(getContext(),4));
        //添加Card默认数据
        mCardListApater = new mineCardListApater(getContext(),titles);
        mineCardList.setAdapter(mCardListApater);
    }

    @Override
    public void initCardData(ArrayList<BaseModel> list) {
        mineCardList.setLayoutManager(new GridLayoutManager(getContext(),4));
        //添加Card默认数据
        mCardListApater = new mineCardListApater(getContext(),list);
        mineCardList.setAdapter(mCardListApater);
    }

    @Override
    public void initMenuData(ArrayList<SimpleMenuModel> list) {
        mineMenuList.setLayoutManager(new LinearLayoutManager(getContext()));
        mMenuListApater = new mineMenuListApater(getContext(),list);
        mMenuListApater.setListener(this);
        mineMenuList.setAdapter(mMenuListApater);
    }

    @Override
    protected int getContainerLayoutID() {
        return R.layout.common_container;
    }

    @Override
    protected int getFailViewId() {
        return R.id.error;
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
        return R.layout.moudle_mine;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.layout_toolbar_mine;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected MineModel getModel() {
        return FindModel(MineModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        initToolbar();
        mPresenter.initCardList();
        mPresenter.initMenuList();

    }

    private void initToolbar() {
        statebarView.setBackgroundColor(getResColor(R.color.white));
        toolbar.setBackgroundColor(getResColor(R.color.white));
        toolbarTitle.setText(getString(R.string.tabhost_mine));
        topImgRight.setImageResource(R.mipmap.setting);
    }

    @Override
    public void navigationPath(String path) {
        LogUtils.d("onViewClicked===navigationPath======="+path);
    }

    @OnClick({R.id.top_img_right, R.id.mine_change, R.id.mine_head_img})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.top_img_right) {
            LogUtils.d("onViewClicked===top_img_right");
        }else if(id == R.id.mine_change){
            LogUtils.d("onViewClicked===mine_change");
        }
        else if(id == R.id.mine_head_img){
            LogUtils.d("onViewClicked===mine_head_img");
        }
    }
}
