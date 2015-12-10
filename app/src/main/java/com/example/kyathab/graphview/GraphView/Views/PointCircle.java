package com.example.kyathab.graphview.GraphView.Views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.example.kyathab.graphview.GraphView.GraphViewFragment;

/**
 * Created by Kyathab on 2015-12-10.
 */
public class PointCircle extends View {
    private static final String TAG = "PointCircle";
    private int XIntervall;
    private int YIntervall;
    private DisplayMetrics metrics;
    private Paint paint = new Paint();
    private int thickness;
    private Color color;
    private int x, y;

    //Offsets
    private int offSetFromTop;
    private int offSetFromRight;
    private int offSetFromLeft;
    private int offSetFromBottom;

    //Min/Max X&Y
    int maxX, maxY;
    int minX, minY;

    private int parentWidth;
    private int parentHeight;

    public PointCircle(Context context, int x, int y,
                       int thickness, int color,
                       int offSetFromTop, int offSetFromRight, int offSetFromLeft, int offSetFromBottom,
                       int maxX, int maxY, int minX, int minY) {
        super(context);

        this.x = x;
        this.y = y;

        this.thickness = thickness;
        paint.setStrokeWidth(thickness);

        if (color != -1) {
            paint.setColor(color);
        } else {
            paint.setColor(Color.BLACK);
        }
        paint.setStyle(Paint.Style.FILL);

        this.offSetFromTop = offSetFromTop;
        this.offSetFromRight = offSetFromRight;
        this.offSetFromBottom = offSetFromBottom;
        this.offSetFromLeft = offSetFromLeft;

        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;

        //Intervalls for X&Y
        metrics = new DisplayMetrics();


        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        XIntervall = (metrics.widthPixels - (offSetFromLeft + offSetFromRight)) / maxX;
        YIntervall = (metrics.heightPixels - (offSetFromTop + offSetFromBottom)) / maxY;

        int cx = offSetFromLeft + (x * XIntervall);
        int cy = (metrics.heightPixels - offSetFromBottom) - (y * YIntervall);

        Log.i(TAG, "CX = " + cx);
        Log.i(TAG, "CY = " + cy);

        Log.i(TAG, "X = " + x);
        Log.i(TAG, "Y = " + y);

        canvas.drawCircle(cx, cy, 25, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}
