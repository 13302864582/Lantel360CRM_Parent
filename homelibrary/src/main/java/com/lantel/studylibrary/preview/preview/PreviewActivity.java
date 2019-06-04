package com.lantel.studylibrary.preview.preview;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/preview")
public class PreviewActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.PREVIEW_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new PreviewFragment();
    }
}
