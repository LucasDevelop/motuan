package com.futrue.frame.widget.materialprogressbar.internal;

import android.content.Context;
import android.content.res.TypedArray;

public class ThemeUtils {

    private ThemeUtils() {}

    public static int getColorFromAttrRes(int attrRes, int defaultValue, Context context) {
        TypedArray a = context.obtainStyledAttributes(new int[] { attrRes });
        try {
            return a.getColor(0, defaultValue);
        } finally {
            a.recycle();
        }
    }

    public static float getFloatFromAttrRes(int attrRes, float defaultValue, Context context) {
        TypedArray a = context.obtainStyledAttributes(new int[] { attrRes });
        try {
            return a.getFloat(0, defaultValue);
        } finally {
            a.recycle();
        }
    }
}
