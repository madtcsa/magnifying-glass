package com.kkxx.example.magnifierdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * @author zsmj
 * @date 2018/4/17
 */
public class Text extends AppCompatTextView {

    // 放大镜的半径
    private static final int RADIUS = 200;
    // 放大倍数
    private static final float FACTOR = 1.1F;
    private int mCurrentX, mCurrentY;

    public Text(Context context) {
        this(context, null);
    }

    public Text(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Text(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCurrentX = (int) event.getX();
        mCurrentY = (int) event.getY();
        return super.onTouchEvent(event);
    }

    public Bitmap loadBitmapFromView() {

        setDrawingCacheEnabled(true);
        buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(getDrawingCache(), mCurrentX - RADIUS,
                mCurrentY - RADIUS, RADIUS * 2, RADIUS * 2);
        Log.d("Text", "----Text------ " + getWidth() + "  " + getHeight());
        Log.d("Text", "----Bitmap------ " + getDrawingCache().getWidth() + "  " + getDrawingCache().getHeight());
        Log.d("Text", "----Event------ " + mCurrentX + "  " + mCurrentY);
        setDrawingCacheEnabled(false);

        return bitmap;
    }
}
