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

        int max_consecutive = 0;

        int consecutive = 0;
        for (Point point : points) {
            if (!MathFunctions.isInCircle(point, radius)) {
                consecutive++;
                max_consecutive = Math.max(consecutive, max_consecutive);
            } else
                consecutive = 0;
        }

        return max_consecutive >= 3;
    }
}
