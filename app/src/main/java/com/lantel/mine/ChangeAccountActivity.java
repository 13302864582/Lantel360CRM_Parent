package com.lantel.mine;

import android.app.Activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.list.model.ChangeAccountBean;
import com.lantel.mine.mvp.ChangeAccountModel;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

@Route(path = "/lantelhome/360/ChangeAccount")
public class ChangeAccountActivity extends FragmentActivity {
    private String account_list_str;
    private ChangeAccountModel model;

    @Override
    protected String getFragmentTag() {
        return "";
    }

    @Override
    public void initView() {
        account_list_str = getIntent().getStringExtra(Config.ACCOUNT_LIST);
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(account_list_str).getAsJsonArray();

        Gson gson = new Gson();
        ArrayList<ChangeAccountBean> changeAccountBeans = new ArrayList<>();

        //加强for循环遍历JsonArray
        for (JsonElement account : jsonArray) {
            //使用GSON，直接转成Bean对象
            ChangeAccountBean userBean = gson.fromJson(account, ChangeAccountBean.class);
            changeAccountBeans.add(userBean);
        }
        model = ViewModelProviders.of(this).get(ChangeAccountModel.class);
        model.setChangeAccountBeans(changeAccountBeans);
        super.initView();
    }

    @Override
    protected Fragment getFragment() {
        return new ChangeAccountFragment();
    }

  @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
