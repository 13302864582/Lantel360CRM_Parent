package com.lantel.homelibrary.output;

import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.fragment.app.Fragment;

public class OutputActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.OUTPUT_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new OutputFragment();
    }
}
