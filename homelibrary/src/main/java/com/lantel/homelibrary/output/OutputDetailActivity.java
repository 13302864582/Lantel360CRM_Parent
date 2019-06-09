package com.lantel.homelibrary.output;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.gyf.immersionbar.BarHide;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.lantel.homelibrary.output.mvp.OutputDetailContract;
import com.lantel.homelibrary.output.mvp.OutputDetailModel;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Map;

import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/output/detail")
public class OutputDetailActivity extends BaseMVPActivity implements OutputDetailContract.View {
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    @BindView(R2.id.share_img)
    ImageView shareImg;
    @BindView(R2.id.share)
    TextView share;
    @BindView(R2.id.remark_img)
    ImageView remarkImg;
    @BindView(R2.id.remark)
    TextView remark;
    @BindView(R2.id.support_img)
    ImageView supportImg;
    @BindView(R2.id.support)
    TextView support;
    @BindView(R2.id.btm_img_layout)
    LinearLayout btmImgLayout;
    @BindView(R2.id.head_img)
    ImageView headImg;
    @BindView(R2.id.line)
    View line;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.img_classes)
    ImageView imgClasses;
    @BindView(R2.id.text_classes)
    TextView textClasses;
    @BindView(R2.id.img_adress)
    ImageView imgAdress;
    @BindView(R2.id.text_adress)
    TextView textAdress;
    @BindView(R2.id.content)
    TextView content;
    @BindView(R2.id.AlbumFileView)
    com.lantel.homelibrary.output.list.AlbumFileView AlbumFileView;
    @BindView(R2.id.time)
    TextView time;
    @BindView(R2.id.line1)
    View line1;
    @BindView(R2.id.card_ConstraintLayout)
    ConstraintLayout cardConstraintLayout;

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
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.ouput_content_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        String data = getIntent().getStringExtra("data");
        if(!TextUtils.isEmpty(data)){
            CardOutputModel cardOutputModel = new Gson().fromJson(data, CardOutputModel.class);
            GlideUtils.loadImageView(this,cardOutputModel.getHeadImg(),headImg);
            name.setText(cardOutputModel.getTitle());
            time.setText(cardOutputModel.getTime());
            content.setText(cardOutputModel.getContent());
            textClasses.setText("未知");
            textAdress.setText("未知");
            Map<String, ArrayList<MediaModel>> map =  cardOutputModel.getMap();
            AlbumFileView.bindImageList(map.get(Config.IMG_LIST));
            AlbumFileView.bindFileList(map.get(Config.FILE_LIST),map.get(Config.RECORD_LIST));
            //AlbumFileView.bindRemarkList();
        }
    }

    @OnClick({R2.id.back, R2.id.share_img, R2.id.share, R2.id.remark_img, R2.id.remark, R2.id.support_img, R2.id.support})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.share_img || id == R.id.share) {
            LogUtils.d("onViewClicked===share_img");
        } else if (id == R.id.remark_img || id == R.id.remark) {
            LogUtils.d("onViewClicked===baremark_imgck");
        } else if (id == R.id.support_img || id == R.id.support) {
            LogUtils.d("onViewClicked===basupport_imgck");
        }
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
