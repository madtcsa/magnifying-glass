package com.kkxx.example.magnifierdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

/**
 * @author kkxx
 * @date 2018/4/17
 */
public class CirclePopupWindow extends PopupWindow {

    private ImageView imageView;

    public CirclePopupWindow(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popwindon, null);
        imageView = view.findViewById(R.id.profile_image);
        this.setContentView(view);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        // this.setAnimationStyle(R.style.AnimBottom);
        // 实例化一个ColorDrawable颜色为全透明
        ColorDrawable dw = new ColorDrawable(context.getColor(android.R.color.transparent));
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

    public void updateImg(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
