package com.example.kyathab.graphview.GraphView.Views;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kyathab.graphview.GraphView.Model.GraphData;

import java.util.ArrayList;

/**
 * Created by Kyathab on 2015-12-25.
 */
public class LabelBox extends RelativeLayout {
    Context context;
    ArrayList<GraphData> datas;

    public LabelBox(Context context, ArrayList<GraphData> datas) {
        super(context);
        this.context = context;
        this.datas = datas;

        for (GraphData d : datas) {
            TextView t = new TextView(context);
            t.setText(d.getLabel());
            t.setTextSize(22);
            this.addView(t);
        }
    }
}
