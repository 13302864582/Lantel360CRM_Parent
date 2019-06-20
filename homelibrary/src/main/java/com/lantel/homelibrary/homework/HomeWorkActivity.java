package com.lantel.homelibrary.homework;

import android.app.Activity;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.ModuleBus;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/homework")
public class HomeWorkActivity extends FragmentActivity {
    private boolean update = false;

    @Override
    protected String getFragmentTag() {
        return "";
    }

    @Override
    protected Fragment getFragment() {
        return new HomeWorkFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(update){
            update = false;
            ModuleBus.getInstance().post(HomeWorkClient.class,"refreshHomework","refreshHomework");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Config.REQUEST_HOMEDETAIL && resultCode == Activity.RESULT_OK){
            update = true;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
