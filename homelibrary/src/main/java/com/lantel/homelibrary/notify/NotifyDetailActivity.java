package com.lantel.homelibrary.notify;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.notify.list.adpter.NotifyDetailAdapter;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/lantel/360/notify/detail")
public class NotifyDetailActivity extends BaseActivity {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.notify_title)
    TextView notify_title;
    @BindView(R2.id.time)
    TextView time;
    @BindView(R2.id.content)
    TextView content;
 /*   @BindView(R2.id.from_title)
    TextView fromTitle;*/
    private String json_Notify = "";

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.notify_detail_layout;
    }

    @Override
    public void initView() {
        title.setText(R.string.notify);
        if (null != getIntent())
            json_Notify = getIntent().getStringExtra(Config.JSON_NOTIFY);
        NotifyItemModel model = new Gson().fromJson(json_Notify,NotifyItemModel.class);
        notify_title.setText(model.getTitle());
        time.setText(model.getTime());
        String contentStr = model.getContent();
        //在第一次调用RichText之前先调用RichText.initCacheDir()方法设置缓存目录，不设置会报错
        RichText.from(contentStr).bind(this)
                .showBorder(false)
                .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                .into(content);
    }


    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束时清空内容
        RichText.clear(this);
    }
}
