package com.yi2580.roundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


/**
 * Created by zhangqi on 2017/9/4.
 * 圆形线性布局
 */

public class RoundRelativeLayout extends RelativeLayout {

    private int[] shapeTypes = new int[]{GradientDrawable.RECTANGLE, GradientDrawable.OVAL, GradientDrawable.LINE, GradientDrawable.RING};

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRelativeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundLatout);
        //显示类型
        int shapeTpe = a.getInt(R.styleable.RoundLatout_viewShapeTpe, shapeTypes[0]);
        //圆角大小
        float cornerRadius = a.getLayoutDimension(R.styleable.RoundLatout_viewCornerRadius, 0);
        float topLeftRadius = a.getLayoutDimension(R.styleable.RoundLatout_viewTopLeftRadius, 0);
        float topRightRadius = a.getLayoutDimension(R.styleable.RoundLatout_viewTopRightRadius, 0);
        float bottomLeftRadius = a.getLayoutDimension(R.styleable.RoundLatout_viewBottomLeftRadius, 0);
        float bottomRightRadius = a.getLayoutDimension(R.styleable.RoundLatout_viewBottomRightRadius, 0);

        //填充色
        int solidColor = a.getColor(R.styleable.RoundLatout_viewSolidColor, 0x0);
        //边框
        int strokeColor = a.getColor(R.styleable.RoundLatout_viewStrokeColor, 0x0);
        int strokeWidth = a.getDimensionPixelSize(R.styleable.RoundLatout_viewStrokeWidth, 0);
        int strokeDashWidth = a.getDimensionPixelSize(R.styleable.RoundLatout_viewStrokeDashWidth, 0);
        int strokeDashGap = a.getDimensionPixelSize(R.styleable.RoundLatout_viewStrokeDashGap, 0);

        a.recycle();

        GradientDrawable gd = new GradientDrawable();

        gd.setColor(solidColor);
        //设置类型
        gd.setShape(shapeTypes[shapeTpe]);
        //类型为矩形才可设置圆角
        if (shapeTypes[shapeTpe] == GradientDrawable.RECTANGLE) {
            if (cornerRadius != 0) {
                gd.setCornerRadius(cornerRadius);
            } else {
                gd.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius});
            }
        }

        gd.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);


        setBackground(gd);
    }

}
