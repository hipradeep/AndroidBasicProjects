package com.hipradeep.learnandroid.utils;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

public class SquireImageView extends AppCompatImageView {

    public SquireImageView(final Context context) {
        super(context);
    }

    public SquireImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public SquireImageView(final Context context, final AttributeSet attrs,
                final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        } else {
            setMeasuredDimension(measuredWidth, measuredWidth);

        }

    }

}