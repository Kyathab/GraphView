package com.example.kyathab.graphview.GraphView.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class IntervallYLabels extends View {

    private static final String TAG = "PointCircle";
    private int XIntervall;
    private int YIntervall;
    private DisplayMetrics metrics;
    private Paint paint = new Paint();
    private int thickness;
    private Color color;
    private int x, y;
    private int textSize = 40;

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

    public IntervallYLabels(Context context, int x, int y,
                            int offSetFromTop, int offSetFromRight, int offSetFromLeft, int offSetFromBottom,
                            int maxX, int maxY, int minX, int minY) {
        super(context);

        this.x = x;
        this.y = y;

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);
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
        XIntervall = (metrics.widthPixels - (offSetFromLeft + offSetFromRight)) / maxX;
        YIntervall = (metrics.heightPixels - (offSetFromTop + offSetFromBottom)) / maxY;

        int cx = offSetFromLeft;
        int cy = (metrics.heightPixels - offSetFromBottom) - (y * YIntervall);
        paint.measureText(Integer.toString(y));


        Log.i(TAG, "Trying to draw IntervallYLabel value = " + y);
        canvas.drawText(Integer.toString(y), cx - 60, cy + (textSize / 2) - 5, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}
