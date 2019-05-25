package com.lantel.homelibrary.notify;

import android.view.View;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.notify.list.adpter.NotifyDetailAdapter;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class NotifyDetailActivity extends BaseActivity {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.detail_list)
    RecyclerView detailList;
    private NotifyDetailAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.notify_detail_layout;
    }

    @Override
    public void initView() {
        title.setText(R.string.notify);
        //添加菜单数据
        ArrayList<BaseModel> menu = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BaseModel model = new BaseModel();
            model.setType(Config.TYPE_IMG);
            menu.add(model);
            BaseModel model2 = new BaseModel();
            model2.setType(Config.TYPE_TEXT);
            menu.add(model2);
        }
        detailList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NotifyDetailAdapter(this,menu);
        detailList.setAdapter(mAdapter);
    }


    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        }
    }
}
