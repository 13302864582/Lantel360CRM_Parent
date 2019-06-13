package com.lantel.homelibrary.course;

import android.app.Activity;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.FragmentActivity;
import com.lantel.homelibrary.app.Config;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@Route(path = "/lantel/360/curriculum")
public class CourseActivity extends FragmentActivity {
    @Override
    protected String getFragmentTag() {
        return Config.COURSE_TAG;
    }

    @Override
    protected Fragment getFragment() {
        return new CourseFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Config.REQUEST_PREVIEW_DETAIL && resultCode == Activity.RESULT_OK){
            ((CourseFragment)mFragment).onRefresh(null);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
