package com.lantel.mine;

import com.lantel.common.FragmentActivity;

import androidx.fragment.app.Fragment;

public class ChangeAccountActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return "";
    }

    @Override
    protected Fragment getFragment() {
        return new ChangeAccountFragment();
    }
}
