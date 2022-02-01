package com.example.LICs;

import com.example.utils.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.PI;

public class LIC2 {

    /**
     * LIC2 checks if there is an angle in the second point of a triangle that consists of three consecutive points that
     * either is less than PI - epsilon or greater than PI + epsilon.
     *
     * @param points  a list of data points
     * @param epsilon a value for deviation
     * @return boolean
     */
    public static boolean LIC2(List<Point> points, double epsilon) {

        if (!(epsilon > 0 && epsilon < PI))
            return false;

        Queue<Point> pointQueue = new LinkedList<>();

        for (Point point : points) {
            pointQueue.add(point);
            if (pointQueue.size() == 3) {
                Point a = pointQueue.poll();
                Point b = pointQueue.poll();
                Point c = pointQueue.poll();
                pointQueue.add(b);
                pointQueue.add(c);
                double angleInB = MathFunctions.calcAngleInPoint2(a, b, c);
                if (angleInB < (Math.toRadians(PI) - epsilon) || angleInB > (Math.toRadians(PI) + epsilon)) {
                    return true;
                }
            }
        }
        return false;
    }
}
