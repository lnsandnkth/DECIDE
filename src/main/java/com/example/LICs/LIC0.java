package com.example.LICs;

import com.example.utils.Point;
import com.example.utils.MathFunctions;
import java.util.List;

public class LIC0 {

    /**
     * LIC0 checks if there exists at least one set of two consecutive data points
     * that are a distance greater than the length
     *
     * @param points List<Point> list of points
     * @param length1 (double) global parameter, distance to be greater than
     * @return true if there are 2 consecutive points further away from each other than length1
     * */
    public static boolean LIC0(List<Point> points, double length1) throws IllegalArgumentException {

        if (length1 < 0) { // Length should not be less than zero
            return false;
        }

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double distance = MathFunctions.calDistance(p1, p2);
            if (distance > length1) {
                return true;
            }
        }
        return false;
    }
}
