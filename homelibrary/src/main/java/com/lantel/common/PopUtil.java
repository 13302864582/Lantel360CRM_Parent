package com.lantel.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.util.AppConfig;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.MediaBean;
import com.xiao360.baselibrary.util.PhotoUtil;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import androidx.fragment.app.Fragment;

public class PopUtil {
    /**
     * 从底部弹出popupwindow
     */
    public void showPickPop(Fragment context, PhotoSelectListener listener) {
       showPickPop(context.getActivity(),listener);
    }

    public void showPickPop(Activity activity, PhotoSelectListener listener) {
        Window window =  activity.getWindow();
        setUpPop(listener, window, activity);
    }

    public void setUpPop(PhotoSelectListener listener, Window window, Context context) {
        final View popView = View.inflate(context, R.layout.bottom_pop_layout, null);
        showAnimation(popView);//开启动画
        PopupWindow mPopWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopWindow.showAtLocation(window.getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setFocusable(true);
        mPopWindow.update();
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.7f;
        window.setAttributes(lp);
        mPopWindow.setOnDismissListener(() -> {
            lp.alpha = 1f;
            window.setAttributes(lp);
        });
        clickPopItem(popView, mPopWindow, context, listener);//条目的点击
    }

    private void clickPopItem(View popView, PopupWindow mPopWindow, Context context, PhotoSelectListener listener) {
        popView.findViewById(R.id.cancel).setOnClickListener((View view) -> {
            mPopWindow.dismiss();
        });
        popView.findViewById(R.id.takePhoto).setOnClickListener((View view) -> {
            try {
                MediaBean photoBean = PhotoUtil.getMediaUri(context, AppConfig.PHOTO);
                if (null != listener && null != photoBean) {
                    listener.onPhotoSelect(photoBean);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.e("Exception==takePhoto" + e.getMessage());
            }
            mPopWindow.dismiss();
        });
        popView.findViewById(R.id.openPhotos).setOnClickListener((View view) -> {
            if (null != listener) {
                listener.onSelectAlbum();
            }
            mPopWindow.dismiss();
        });
    }

    /**
     * 给popupwindow添加动画
     *
     * @param popView
     */
    private void showAnimation(View popView) {
        AnimationSet animationSet = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1.0f);
        alphaAnimation.setDuration(300);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f
        );
        translateAnimation.setDuration(300);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        popView.startAnimation(animationSet);
    }
}
