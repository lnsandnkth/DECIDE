package com.example.LICs;

import com.example.utils.Point;
import com.example.utils.MathFunctions;
import java.util.List;

public class LIC8 {
    /**
     * LIC8 - Launch Interceptor Condition #8
     * Checks if there is a set of 3 points separated by exactly APt and BPts consecutive intervening points respectively
     * that can not all be contained within or on a circle of radius1
     * @param points List<Point> list of points to iterate on
     * @param APts number of consecutive points
     * @param BPts number of consecutive points
     * @param radius1 radius of the circle
     * @return (boolean) true is there are 3 points outside the circle
     */
    public static boolean LIC8(List<Point> points, int APts, int BPts, double radius1) {
        if (points.size() < 5 || APts < 1 || BPts < 1) {
            return false;
        }
        if (points.size() - APts - BPts - 2 < 0) {
            return false;
        }
        for (int i = 0; i < points.size() - APts - BPts - 2; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + APts + 1);
            Point p3 = points.get(i + APts + BPts + 2);
            double smallestRadius = MathFunctions.calCircleByPoints(p1, p2, p3);
            if (smallestRadius > radius1) {
                return true;
            }
        }
        return false;
    }
}
