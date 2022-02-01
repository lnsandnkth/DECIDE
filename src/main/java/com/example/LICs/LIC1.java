package com.example.LICs;

import com.example.utils.Point;
import com.example.utils.MathFunctions;
import java.util.List;


public class LIC1 {

    /**
     * LIC1 - Launch Interceptor Condition #1
     * Checks if there is a set of 3 consecutive points outside a circle in an ordered list of points
     * @param points List<Point> list of points to iterate on
     * @param radius radius of the circle outside of which the points must be
     * @return (boolean) true is there are 3 consecutive points outside the circle in the list
     */
    public static boolean LIC1(List<Point> points, double radius) {

        if (radius < 0) {
            return false;
        }

        for (int i = 2; i < points.size(); i++) {

            Point p1 = points.get(i);
            Point p2 = points.get(i - 1);
            Point p3 = points.get(i - 2);

            if (MathFunctions.calCircleByPoints(p1, p2, p3) > radius) {
                return true;
            }

        }

        return false;
    }
}
