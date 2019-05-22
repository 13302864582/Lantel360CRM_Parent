package com.lantel.homelibrary.accessment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseMVPActivity;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/lantel/360/assessment")
public class AccessMentActivity extends FragmentActivity {

    @Override
    protected String getFragmentTag() {
        return Config.ACCESSMENT_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new AccessMentFragment();
    }
}
