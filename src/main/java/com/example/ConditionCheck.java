package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

public class ConditionCheck {

    private double PI = 3.1415926535;

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
        return sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }


    /**
     * LIC2 checks if there is an angle in the second point of a triangle that consists of three consecutive points that
     * either is less than PI - epsilon or greater than PI + epsilon.
     *
     * @param points  a list of data points
     * @param epsilon a value for deviation
     * @return boolean
     */
    public boolean LIC2(List<Point> points, float epsilon)  {
        Queue<Point> pointQueue = new LinkedList<>();

        for (Point point : points) {
            pointQueue.add(point);
            if (pointQueue.size() == 3) {
                Point a = pointQueue.poll();
                Point b = pointQueue.poll();
                Point c = pointQueue.poll();
                pointQueue.add(b);
                pointQueue.add(c);
                double angleInB = calcAngleInPoint2(a, b, c);
                if (angleInB < (180 - epsilon) || angleInB > (180 + epsilon)) {
                    return true;
                }
            }
        }
        return false;
    }

    private double calcAngleInPoint2(Point p1, Point p2, Point p3) {
        double a2 = Math.pow(calDistance(p2, p3), 2);
        double b2 = Math.pow(calDistance(p1, p3), 2);
        double c2 = Math.pow(calDistance(p1, p2), 2);
        float a = (float) sqrt(a2);
        float c = (float) sqrt(c2);
        float angleInP2 = (float) acos((a2 + c2 - b2) / (2 * a * c));
        angleInP2 = (float) (angleInP2 * 180 / PI);
        return angleInP2;
    }
}
