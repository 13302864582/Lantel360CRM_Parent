package com.lantel.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.api.MineCardBean;
import com.lantel.mine.list.adpter.mineCardListApater;
import com.lantel.mine.list.adpter.mineMenuListApater;
import com.lantel.mine.list.model.CardModel;
import com.lantel.mine.mvp.MineContract;
import com.lantel.mine.mvp.MineModel;
import com.lantel.mine.mvp.MinePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @BindView(R.id.empty_add_layout)
    RelativeLayout empty_add_layout;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private mineCardListApater mCardListApater;
    private mineMenuListApater mMenuListApater;
    private List<MineCardBean.DataBean.ListBean> mCardList;
    private String sid;

    @Override
    public void notifyCardData(MineCardBean cardBean) {
        mCardList = cardBean.getData().getList();
        for(MineCardBean.DataBean.ListBean bean : mCardList){
            if(bean.getSid().equals(sid)){
                mineName.setText(bean.getStudent_name());
                mineCall.setText(bean.getNick_name());
                GlideUtils.loadCircle(getContext(),bean.getPhoto_url(),mineHeadImg);
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bean.getBirth_time());
                    mineAge.setText(DisplayUtil.getAge(date,getContext()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                mineStudentId.setText(bean.getSno());
                mineCardId.setText(bean.getCard_no());
                String total = bean.getStudent_lesson_hours();
                String remain = bean.getStudent_lesson_remain_hours();
                String use = (Float.valueOf(total) - Float.valueOf(remain))+"";
                ArrayList<CardModel> cardList = new ArrayList<>();
                CardModel credit = new CardModel(bean.getCredit());
                CardModel totaltime = new CardModel(total);
                CardModel remaintime = new CardModel(remain);
                CardModel usetime = new CardModel(use);
                cardList.add(credit);
                cardList.add(totaltime);
                cardList.add(remaintime);
                cardList.add(usetime);
                mCardListApater.setDatas(cardList);
                mCardListApater.notifyDataSetChanged();
            }
        }

    }



    @Override
    public void initCardData(String[] titles) {
        mineCardList.setLayoutManager(new GridLayoutManager(getContext(),4));
        //添加Card默认数据
        mCardListApater = new mineCardListApater(getContext(),titles);
        mineCardList.setAdapter(mCardListApater);
    }


    @Override
    public void initMenuData(ArrayList<SimpleMenuModel> list) {
        sid = SpCache.getString(Config.SID,"21");
        mineMenuList.setLayoutManager(new LinearLayoutManager(getContext()));
        mMenuListApater = new mineMenuListApater(getContext(),list);
        mMenuListApater.setListener(this);
        mineMenuList.setAdapter(mMenuListApater);
    }

    @Override
    public void LoadCardFail() {

    }

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
    }

    private void initToolbar() {
        statebarView.setBackgroundColor(getResColor(R.color.white));
        toolbar.setBackgroundColor(getResColor(R.color.white));
        toolbarTitle.setText(getString(R.string.tabhost_mine));
        topImgRight.setImageResource(R.mipmap.setting);
    }

    @Override
    public void navigationPath(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    @OnClick({R.id.top_img_right, R.id.mine_change, R.id.mine_head_img,R.id.add_account})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.top_img_right) {
            ARouter.getInstance().build("/lantelhome/360/SettingActivity").navigation();
        }else if(id == R.id.mine_change){
            int count = mCardListApater.getItemCount();
            if(count!=0){
                Intent intent = new Intent(getContext(),ChangeAccountActivity.class);
                Gson gson =new Gson();
                LogUtils.d("onViewClicked====="+gson.toJson(mCardListApater.getDatas()));
                startActivity(intent);
            }
        }else if(id == R.id.mine_head_img){

        }else if(id == R.id.add_account){
            ARouter.getInstance().build("/lantelhome/360/ChangeAccount").navigation();
        }
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
}
