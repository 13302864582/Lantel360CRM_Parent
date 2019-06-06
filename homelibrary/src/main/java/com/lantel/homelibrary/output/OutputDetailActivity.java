package com.lantel.homelibrary.output;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.lantel.homelibrary.output.mvp.OutputDetailContract;
import com.lantel.homelibrary.output.mvp.OutputDetailModel;
import com.lantel.homelibrary.output.mvp.OutputDetailPresenter;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import butterknife.OnClick;

@Route(path = "/lantel/360/output/detail")
public class OutputDetailActivity extends BaseMVPActivity<OutputDetailPresenter,OutputDetailModel> implements OutputDetailContract.View {
    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected OutputDetailModel getModel() {
        return FindModel(OutputDetailModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.ouput_content_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

    }

    @OnClick({R2.id.back, R2.id.share_img, R2.id.share, R2.id.remark_img, R2.id.remark, R2.id.support_img, R2.id.support})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
            LogUtils.d("onViewClicked===back");
        }else if(id == R.id.share_img || id == R.id.share){
            LogUtils.d("onViewClicked===share_img");
        }else if(id == R.id.remark_img || id == R.id.remark){
            LogUtils.d("onViewClicked===baremark_imgck");
        }else if(id == R.id.support_img || id == R.id.support){
            LogUtils.d("onViewClicked===basupport_imgck");
        }
    }

    @Override
    public void initCourseData(BaseModel menu) {
      /*  OutputDetailModel model = (OutputDetailModel) menu;
        bindImageList(model.getImgs());*/
    }

    private void bindImageList(String[] images) {
       /* RecyclerView.LayoutManager manager =  null;
        int count = images.length;
        ConstraintSet set= new ConstraintSet();
        //获取当前使用的约束布局
        set.clone(card_ConstraintLayout);

        if(count == 1){
            set.constrainPercentWidth(R.id.img_list,1f);
            manager = new LinearLayoutManager(this);
        }else if(count == 4){
            set.constrainPercentWidth(R.id.img_list,0.66f);
            manager = new GridLayoutManager(this,2);
        }else{
            set.constrainPercentWidth(R.id.img_list,1f);
            manager = new GridLayoutManager(this,3);
        }
        //最后一步就是设置新的ConstraintLayout约束 这个必须设置;
        set.applyTo(card_ConstraintLayout);
        ImagAdapter adapter = new ImagAdapter(this, Arrays.asList(images),manager);
        imgList.setLayoutManager(manager);
        imgList.setAdapter(adapter);*/
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }
}
