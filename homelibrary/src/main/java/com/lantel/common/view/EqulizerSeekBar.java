package com.lantel.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;

import java.text.DecimalFormat;

public class EqulizerSeekBar extends View {
    private Paint mPaint ;
    private float perWidth = 1f;
    private RectF rectF = new RectF();
    Bitmap targetBgBit = null;
    Bitmap targetColorBit = null;
    private int centerX = 0;
    private int realH = 0;
    private float progress = 0;
    private float Maxprogress = 100;
    private int realW;
    private Paint mTextPaint;

    public EqulizerSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        init();
    }

    public EqulizerSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setMaxprogress(float maxprogress) {
        Maxprogress = maxprogress;
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = 0;
        rectF.bottom = h;

        realH = getHeight()-getPaddingTop()-getPaddingBottom();
        realW = getWidth()-getPaddingLeft()-getPaddingRight();
        perWidth = realW * 1.0f / Maxprogress;
        rectF.right = getPaddingLeft() + progress * perWidth;
    }

    private void initBitmap() {
        Bitmap colorBg = BitmapFactory.decodeResource(getResources(), R.mipmap.seek_bg_top);
        Bitmap bg = BitmapFactory.decodeResource(getResources(), R.mipmap.seek_bg_bottom);
        Matrix matrix = new Matrix();
        matrix.postScale(realW*1.0f/colorBg.getWidth(),realH*1.0f/colorBg.getHeight());
        targetBgBit = Bitmap.createBitmap(bg,0,0,bg.getWidth(),
                bg.getHeight(), matrix, false);
        targetColorBit = Bitmap.createBitmap(colorBg, 0, 0, colorBg.getWidth(),
                colorBg.getHeight(), matrix, false);
        centerX = (getWidth() - targetColorBit.getWidth())/2;
        bg.recycle();
        colorBg.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(targetBgBit != null)
            canvas.drawBitmap(targetBgBit, centerX, getPaddingTop(), null);

        if(rectF.right<getPaddingLeft())
            rectF.right = getPaddingLeft();
        if(rectF.right>realW)
            rectF.right = realW;

        if(targetColorBit != null) {
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawBitmap(targetColorBit, centerX, getPaddingTop(), null);
            canvas.restore();
        }
    }

    //设置 预设值
    public void setProgress(float progress){
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initBitmap();
    }
}
