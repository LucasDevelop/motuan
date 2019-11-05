package com.futrue.frame.widget;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;


/**
 * @创建者 shen
 * @描述 Popup
 */
public class PopupView extends PopupWindow {


    public PopupView(final Context context, View view) {
        super(context);

        //设置按钮监听
        //设置SelectPicPopupWindow的View
        this.setContentView(view);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setClippingEnabled(false);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(Color.argb(90, 0, 0, 0));
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);


    }
}
