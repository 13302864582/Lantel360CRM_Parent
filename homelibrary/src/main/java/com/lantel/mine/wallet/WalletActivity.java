package com.lantel.mine.wallet;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;

import androidx.fragment.app.Fragment;

import static com.lantel.homelibrary.app.Config.WALLET_TAG;

@Route(path = "/lantel/360/wallet")
public class WalletActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return WALLET_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new WalletFragment();
    }
}
