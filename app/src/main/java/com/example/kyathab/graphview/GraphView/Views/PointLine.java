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

/**
 * Created by Kyathab on 2015-12-11.
 */
public class PointLine extends View {

    private static final String TAG = "PointCircle";

    private DisplayMetrics metrics;
    private int parentWidth;
    private int parentHeight;
    private int XIntervall;
    private int YIntervall;

    private Paint paint = new Paint();
    private int thickness;
    private int color;

    //Offsets
    private int offSetFromTop;
    private int offSetFromRight;
    private int offSetFromLeft;
    private int offSetFromBottom;

    //Min/Max X&Y
    int maxX, maxY;
    int minX, minY;

    //Start points and end points
    private int startX, endX;
    private int startY, endY;

    public PointLine(Context context,
                     int startX, int endX, int startY, int endY,
                     int thickness, int color,
                     int offSetFromTop, int offSetFromRight, int offSetFromLeft, int offSetFromBottom,
                     int maxX, int maxY, int minX, int minY) {
        super(context);

        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;

        this.thickness = thickness;
        this.color = color;
        this.thickness = thickness;
        paint.setStrokeWidth(thickness);
        if (color != -1) {
            paint.setColor(color);
        } else {
            paint.setColor(Color.BLACK);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        this.offSetFromTop = offSetFromTop;
        this.offSetFromRight = offSetFromRight;
        this.offSetFromBottom = offSetFromBottom;
        this.offSetFromLeft = offSetFromLeft;

        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;

        metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        XIntervall = (parentWidth - (offSetFromLeft + offSetFromRight)) / maxX;
        YIntervall = (parentHeight - (offSetFromTop + offSetFromBottom)) / maxY;

        int graphStartX = offSetFromLeft + (startX * XIntervall);
        int graphEndX = offSetFromLeft + (endX * XIntervall);
        int graphStartY = (parentHeight - offSetFromBottom) - (startY * YIntervall);
        int graphEndY = (parentHeight - offSetFromBottom) - (endY * YIntervall);

        canvas.drawLine(graphStartX, graphStartY, graphEndX, graphEndY, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}
