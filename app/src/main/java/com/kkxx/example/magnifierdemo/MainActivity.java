package com.kkxx.example.magnifierdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Text textView;
    ImageView imageView;
    PopupWindow popupWindow;
    CirclePopupWindow circlePopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.image);
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.popwindon, null);
        popupWindow.setContentView(view);
//        popupWindow.showAtLocation(textView, Gravity.NO_GRAVITY, 0, 0);
        imageView = view.findViewById(R.id.profile_image);
        circlePopupWindow = new CirclePopupWindow(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        textView.onTouchEvent(ev);
        circlePopupWindow.updateImg(textView.loadBitmapFromView());
        if (circlePopupWindow.isShowing()) {
            circlePopupWindow.update((int) ev.getX(), (int) ev.getY(), popupWindow.getWidth(), popupWindow.getHeight());
        } else {
            circlePopupWindow.showAtLocation(textView, Gravity.NO_GRAVITY, (int) ev.getX(), (int) ev.getY());
        }
        return super.dispatchTouchEvent(ev);
    }
}
