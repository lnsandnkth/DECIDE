package com.example.LICs;

import com.example.utils.Point;
import com.example.utils.MathFunctions;
import java.util.List;

public class LIC3 {

    /**
     * LIC3 - Launch Interceptor Condition #3
     * Checks if exists a triangle(formed by three consecutive data points) with area greater than area1.
     * @param points List<Point> list of points to iterate on
     * @param area1 the area to compare with
     * @return (boolean) true is there exists such triangle
     */
    public static boolean LIC3(List<Point> points, double area1) throws IllegalArgumentException {

        if (area1 < 0) { // Area should not be less than zero
            return false;
        }
        if (points.size() < 3) { // There should be at least three points
            return false;
        }

        for (int i = 0; i < points.size() - 2; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            Point p3 = points.get(i + 2);
            if (MathFunctions.isTriangleArea(p1, p2, p3) - area1 > 0.000001) return true;
        }
        return false;
    }
}
