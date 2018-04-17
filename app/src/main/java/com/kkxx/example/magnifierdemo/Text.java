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
    private static final int RADIUS = 100;
    // 放大倍数
    private static final float FACTOR = 1.1F;
    private int mCurrentX, mCurrentY;
    private final Path mPath = new Path();
    private final Matrix matrix = new Matrix();

    public Text(Context context) {
        this(context, null);
    }

    public Text(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Text(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPath.addCircle(RADIUS, RADIUS, RADIUS, Path.Direction.CW);
        matrix.setScale(FACTOR, FACTOR);
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
        Bitmap bitmap = Bitmap.createBitmap(getDrawingCache(), mCurrentX - RADIUS - (int) getX(),
                mCurrentY - RADIUS - (int) getY(), RADIUS * 2, RADIUS * 2);
//        Log.d("Text", "---bitmap---- " + bitmap.getWidth() + "  " + bitmap.getHeight());
//        Log.d("Text", "---mCurrentX---- " + mCurrentX);
//        Log.d("Text", "---mCurrentY---- " + mCurrentY);
        setDrawingCacheEnabled(false);

        return bitmap;
    }
}
