package com.lantel.homelibrary.notify;

import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.notify.list.adpter.NotifyAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/notify")
public class NotifyActivity extends BaseActivity {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private NotifyAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.notify_layout;
    }

    @Override
    public void initView() {
        title.setText(R.string.notify);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NotifyAdapter(this,null);
        recyclerView.setAdapter(mAdapter);

        //添加菜单数据
        ArrayList<BaseModel> menu = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            BaseModel model = new BaseModel();
            menu.add(model);
        }
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }


    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
            finish();
        }
    }
}
