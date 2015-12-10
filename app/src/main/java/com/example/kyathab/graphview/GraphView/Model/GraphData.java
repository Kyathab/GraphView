package com.example.kyathab.graphview.GraphView.Model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kyathab on 2015-12-10.
 */
public class GraphData {
    private String label = null;
    private int graphColor = -1;
    private int graphCircleThickness = 5;
    private int graphLineThickness = 3;
    private ArrayList<XYCoords> points = new ArrayList<>();

    public ArrayList<XYCoords> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<XYCoords> points) {
        this.points = points;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getGraphColor() {
        return graphColor;
    }

    public void setGraphColor(int graphColor) {
        this.graphColor = graphColor;
    }

    public int getGraphCircleThickness() {
        return graphCircleThickness;
    }

    public void setGraphCircleThickness(int graphCircleThickness) {
        this.graphCircleThickness = graphCircleThickness;
    }

    public int getGraphLineThickness() {
        return graphLineThickness;
    }

    public void setGraphLineThickness(int graphLineThickness) {
        this.graphLineThickness = graphLineThickness;
    }

    @Override
    public String toString() {
        return "GraphData{" +
                "label='" + label + '\'' +
                ", graphColor='" + graphColor + '\'' +
                ", graphCircleThickness=" + graphCircleThickness +
                ", graphLineThickness=" + graphLineThickness +
                ", points=" + points +
                '}';
    }
}
