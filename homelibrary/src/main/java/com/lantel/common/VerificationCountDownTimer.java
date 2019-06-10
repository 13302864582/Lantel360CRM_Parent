package com.lantel.common;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import com.lantel.homelibrary.R;

public class VerificationCountDownTimer extends CountDownTimer {
    private Context mContext;
    private TextView mTextView;

    /**
     * 类中的构造函数
     */
    public VerificationCountDownTimer(Context context,TextView text){
        super(60000, 1000);
        this.mContext = context;
        this.mTextView = text;
        mTextView.setClickable(false);
        start();
    }


    /**
     * 当前任务每完成一次倒计时间隔时间时回调
     * @param millisUntilFinished
     */
    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setText(String.format(mContext.getString(R.string.second_format),millisUntilFinished/1000));
    }


    /**
     * 当前任务完成的时候回调
     */
    @Override
    public void onFinish() {
        mTextView.setText(R.string.accept_check_sms);
        mTextView.setClickable(true);
    }
}
