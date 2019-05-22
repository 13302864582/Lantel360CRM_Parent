package com.xiao360.baselibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.baselibrary.R;
import com.xiao360.baselibrary.edit.NormalStateLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

public abstract class ToolBarFragment<T extends BaseFragmentPresenter, E extends ViewModel> extends BaseMVPFragment<T, E> {
    protected NormalStateLayout stateLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (super.rootView == null)
            super.rootView = getInflate(R.layout.toolbar_state,inflater, container);
        LinearLayout linearLayout = (LinearLayout) super.rootView;
        //添加toolbar容器
        if(getToolBarLayoutID()!=-1){
            LinearLayout.LayoutParams params0 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            linearLayout.addView(getInflate(getToolBarLayoutID(),inflater, container),params0);
        }
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    protected abstract int getToolBarLayoutID();

    private View getInflate(int layoutRes,LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(layoutRes, container, false);
    }

    @Override
    protected int getLayoutResource() {
        return -1;
    }
}
