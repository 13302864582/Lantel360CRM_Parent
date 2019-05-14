package com.lantel.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.lantel.homelibrary.R;

public class TextSeekBar extends RelativeLayout {
    private int default_percent;
    private String titleText;
    private String percentText;

    public TextSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.text_seekbar,this,true);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextSeekBarStyle);
        default_percent = ta.getInteger(R.styleable.TextSeekBarStyle_default_percent,0);
        titleText = ta.getString(R.styleable.TextSeekBarStyle_titleText);
        percentText = ta.getString(R.styleable.TextSeekBarStyle_percentText);
    }
}
