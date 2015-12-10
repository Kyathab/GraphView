package com.example.kyathab.graphview.GraphView.Model;

/**
 * Created by Kyathab on 2015-12-10.
 */
public class XYCoords {
    int x;
    int y;

    public XYCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "XYCoords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}