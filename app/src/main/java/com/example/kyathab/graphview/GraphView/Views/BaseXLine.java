package com.example.kyathab.graphview.GraphView.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Kyathab on 2015-12-01.
 */
public class BaseXLine extends View {
    private static final String TAG = "BaseXline";
    private final DisplayMetrics metrics;
    Paint paint = new Paint();
    private int parentWidth;
    private int parentHeight;
    private int offSetFromTop = 200;
    private int offSetFromBottom = 200;
    private int offSetFromRight = 200;
    private int offSetFromLeft = 200;


    public BaseXLine(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5f);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "Screen Width px(Metrics): " + metrics.widthPixels
                + " Screen Height px(Metrics): " + metrics.heightPixels
                + " Screen Width px: " + parentWidth
                + " Screen Height px: " + parentHeight);

        canvas.drawLine(offSetFromLeft, parentHeight - offSetFromBottom, parentWidth - offSetFromRight, parentHeight - offSetFromBottom, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
    }
}

