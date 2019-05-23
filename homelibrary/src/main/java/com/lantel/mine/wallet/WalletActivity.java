package com.lantel.mine.wallet;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;

import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/wallet")
public class WalletActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return "";
    }

    @Override
    protected Fragment getFragment() {
        return new WalletFragment();
    }
}
