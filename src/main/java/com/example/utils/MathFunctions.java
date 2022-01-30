package com.example.utils;
import com.example.utils.Point;
import java.util.List;

import static java.lang.Math.*;

public class MathFunctions {

    public static double calDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    /**
     * Computes the length / size / norm of a vector
     * @param p vector
     * @see Point
     * @return (double) length / size / norm of p
     */
    public static double calNorm(Point p) {

        return Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
    }

    /**
     * Checks if a point is inside (or on the border) of a circle centered on (0, 0)
     * @param p point
     * @param radius radius of the circle
     * @see Point
     * @return (boolean) true if Point p is inside (or on the border) of the circle
     */
    public static boolean isInCircle(Point p, double radius) {

        return calNorm(p) <= radius;
    }

    /**
     * Checks if three points form a triangle and return the area if it is
     * @param p1 point
     * @return (double) area of the triangle if it is a triangle, otherwise return 0
     */
    public static double isTriangleArea(Point p1, Point p2, Point p3) {
        return 0.5 * (p1.getX() * (p2.getY() - p3.getY())
                + p2.getX() * (p3.getY() - p1.getY())
                + p3.getX() * (p1.getY() - p2.getY()));
    }

    public static double calcAngleInPoint2(Point p1, Point p2, Point p3) {
        double a2 = Math.pow(calDistance(p2, p3), 2);
        double b2 = Math.pow(calDistance(p1, p3), 2);
        double c2 = Math.pow(calDistance(p1, p2), 2);
        float a = (float) sqrt(a2);
        float c = (float) sqrt(c2);
        float angleInP2 = (float) acos((a2 + c2 - b2) / (2 * a * c));
        angleInP2 = (float) (angleInP2 * 180 / PI);
        return angleInP2;
    }

    public static double calcPhase(Point p) {

        return (Math.atan2(p.getY(), p.getX()) + 2 * PI) % (2 * PI);
    }

    public static int calcQuadrant(Point p) {

        double phase = calcPhase(p) % (2 * PI);

        return (int)(2 * phase / PI);
    }
}
