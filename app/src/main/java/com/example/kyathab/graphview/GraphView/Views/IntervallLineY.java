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
public class IntervallLineY extends View {
    private static final String TAG = "PointCircle";
    private int k;
    private int intervallsY;
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
    private int YIntervall;
    private int XIntervall;

    public IntervallLineY(Context context,
                          int offSetFromTop, int offSetFromRight, int offSetFromLeft, int offSetFromBottom,
                          int maxX, int maxY, int minX, int minY, int k) {
        super(context);



        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);

        this.offSetFromTop = offSetFromTop;
        this.offSetFromRight = offSetFromRight;
        this.offSetFromBottom = offSetFromBottom;
        this.offSetFromLeft = offSetFromLeft;

        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;
        this.k = k;

        metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        XIntervall = (parentWidth - (offSetFromLeft + offSetFromRight)) / maxX;
        YIntervall = (parentHeight - (offSetFromTop + offSetFromBottom)) / maxY;

        int cx = offSetFromLeft;
        int cy = (parentHeight - offSetFromBottom) - (k * YIntervall);

        if(y == 0){
            canvas.drawLine(cx - 20, cy, cx, cy, paint);
        } else {
            canvas.drawLine(cx - 20, cy, cx + 20, cy, paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}
