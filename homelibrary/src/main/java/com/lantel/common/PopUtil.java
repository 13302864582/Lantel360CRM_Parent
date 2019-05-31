package com.lantel.common;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.PhotoUtil;

public class PopUtil {
    /**
     * 从底部弹出popupwindow
     */
    public void showPickPop(Activity context, PhotoSelectListener listener) {
        final View popView = View.inflate(context, R.layout.bottom_pop_layout, null);
        showAnimation(popView);//开启动画
        PopupWindow mPopWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopWindow.showAtLocation(context.getWindow().getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setFocusable(true);
        mPopWindow.update();
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = 0.7f;
        context.getWindow().setAttributes(lp);
        mPopWindow.setOnDismissListener(() -> {
            lp.alpha = 1f;
            context.getWindow().setAttributes(lp);
        });
        clickPopItem(popView, mPopWindow, context, listener);//条目的点击
    }

    private void clickPopItem(View popView, PopupWindow mPopWindow, Activity context, PhotoSelectListener listener) {
        popView.findViewById(R.id.cancel).setOnClickListener((View view) -> {
            LogUtils.d("clickPopItem==cancel");
            mPopWindow.dismiss();
        });
        popView.findViewById(R.id.takePhoto).setOnClickListener((View view) -> {
            try {
                Uri uri = PhotoUtil.takePhoto(context,Config.REQUEST_TAKE_PHOTO);
                if (null != listener) {
                    listener.onPhotoSelect(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.e("Exception==takePhoto" + e.getMessage());
            }
            mPopWindow.dismiss();
        });
        popView.findViewById(R.id.openPhotos).setOnClickListener((View view) -> {
            LogUtils.d("clickPopItem==openPhotos");
            PhotoUtil.selectPhoto(context, Config.REQUEST_SELECT_PHOTO);
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
