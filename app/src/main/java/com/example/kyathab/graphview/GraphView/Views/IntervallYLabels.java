package com.example.kyathab.graphview.GraphView.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class IntervallYLabels extends View {

    private int YIntervall;
    private DisplayMetrics metrics;
    private Paint paint = new Paint();
    private int textSize = 40;

    //Offsets
    private int offSetFromTop;
    private int offSetFromRight;
    private int offSetFromLeft;
    private int offSetFromBottom;

    //Min/Max X&Y
    int maxX, maxY;
    int minX, minY;
    private int k;

    private int parentWidth;
    private int parentHeight;

    public IntervallYLabels(Context context,
                            int offSetFromTop, int offSetFromRight, int offSetFromLeft, int offSetFromBottom,
                            int maxX, int maxY, int minX, int minY, int k) {
        super(context);

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
        this.k = k;

        metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        YIntervall = (parentHeight - (offSetFromTop + offSetFromBottom)) / maxY;

        int cx = offSetFromLeft;
        int cy = (parentHeight - offSetFromBottom) - (k * YIntervall);
        paint.measureText(Integer.toString(k));

        canvas.drawText(Integer.toString(k), cx - 60, cy + (textSize / 2) - 5, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}
