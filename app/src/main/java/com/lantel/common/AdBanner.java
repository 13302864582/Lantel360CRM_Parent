package com.lantel.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.lantel.crmparent.R;
import com.youth.banner.Banner;

public class AdBanner extends Banner {
    private float scale_wh;

    public AdBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BannerStyle);
        scale_wh = ta.getFloat(R.styleable.BannerStyle_scale_wh,2.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        float height = width/scale_wh;
        setMeasuredDimension(width, (int) height);
    }
}
