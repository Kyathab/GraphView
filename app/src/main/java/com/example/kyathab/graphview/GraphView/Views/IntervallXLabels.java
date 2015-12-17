package com.example.kyathab.graphview.GraphView.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Kyathab on 2015-12-17.
 */
public class IntervallXLabels extends TextView {

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

    public IntervallXLabels(Context context, int x, int y,
                            int offSetFromTop, int offSetFromRight, int offSetFromLeft, int offSetFromBottom,
                            int maxX, int maxY, int minX, int minY) {
        super(context);

        this.x = x;
        this.y = y;

        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(22);

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

        int cx = offSetFromLeft + (x * XIntervall);
        int cy = (metrics.heightPixels - offSetFromBottom);

        if (x == 0) {
            canvas.drawText(Integer.toString(x), cy - 100 , cx, paint);
        } else {
            canvas.drawText(Integer.toString(x), cy - 100, cx, paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}
