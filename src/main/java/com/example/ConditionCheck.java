package com.example;

import com.example.Point;

import java.util.List;

public class ConditionCheck {
    /*
    * LIC0 checks if there exists at least one set of two consecutive data points
    *  that are a distance greater than the length
    * */
    public boolean LIC0(List<Point> points, double length1) throws IllegalArgumentException {
        if (length1 < 0) {
            throw new IllegalArgumentException("Length should not be less than zero");
        }
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double distance = calDistance(p1, p2);
            if (distance > length1) {
                return true;
            }
        }
        return false;
    }


    private double calDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
}
