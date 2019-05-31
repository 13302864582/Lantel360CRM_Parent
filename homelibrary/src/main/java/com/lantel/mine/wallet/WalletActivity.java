package com.lantel.mine.wallet;

import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.wallet.mvp.WalletModel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import static com.lantel.homelibrary.app.Config.WALLET_TAG;

@Route(path = "/lantel/360/wallet")
public class WalletActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return WALLET_TAG;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        WalletModel walletModel = ViewModelProviders.of(this).get(WalletModel.class);
        if(null != intent.getStringExtra(Config.WALLLET_MONEY)){
            String walletMoney = intent.getStringExtra(Config.WALLLET_MONEY);
            walletModel.setWalletMoney(walletMoney);
        }
        if(null != intent.getStringExtra(Config.SID)){
            String sid = intent.getStringExtra(Config.SID);
            walletModel.setSid(sid);
        }
        super.initView();
    }

    @Override
    protected Fragment getFragment() {
        return new WalletFragment();
    }
}
