package com.liuxuejian.planefight.utils;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.liuxuejian.planefight.base.CCApplication;


public class ResourceUtil {

    public static int getColor(int colorResId) {
        return ContextCompat.getColor(CCApplication.getInstance(), colorResId);
    }

    public static int getDimensionPixelSize(int dimenRes) {
        return CCApplication.getInstance().getResources().getDimensionPixelSize(dimenRes);
    }

    public static String getString(int strResId) {
        return CCApplication.getInstance().getString(strResId);
    }

    public static String getString(int strResId, Object... objects) {
        return String.format(getString(strResId), objects);
    }

    @Nullable
    public static Drawable getDrawable(int drawableResId) {
        if (drawableResId == 0) {
            return null;
        } else {
            return ContextCompat.getDrawable(CCApplication.getInstance(), drawableResId);
        }
    }

}
