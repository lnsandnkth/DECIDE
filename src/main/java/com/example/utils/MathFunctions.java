package com.example.utils;

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
        return angleInP2;
    }

    /**
     * Computes the phase of a point, ie the angle between the vector and the (1, 0) vector.
     * @param p Point to compute the phase of
     * @see Point
     * @return the phase of the point in radians, counterclockwise direction in [0, 2*PI]
     */
    public static double calcPhase(Point p) {

        return (Math.atan2(p.getY(), p.getX()) + 2 * PI) % (2 * PI);
    }

    /**
     * Computes the quadrant in which a point is.
     * @param p Point to compute the quadrant of
     * @see Point
     * @see MathFunctions#calcPhase(Point) is used to determine the quadrant
     * @return integer in [1, 4] representing the quadrant in counterclockwise direction. returns the lowest quadrant number if the point is in between two quadrants
     */
    public static int calcQuadrant(Point p) {

        double phase = calcPhase(p) % (2 * PI);

        if (p.getX() == 0 || p.getY() == 0) { // if we're on a line
            return 1 + Math.max(0, (int)(2*phase / PI) - 1); // get the quadrant before (smallest quadrant number), max with 0 for the case between quadrant 1 and 4
        }

        return 1 + (int)(2 * phase / PI); // normal case
    }

    
  /**
     * computes the distance between a point a and a line form l1 to l2
     * @param l1 one point of the line
     * @param l2 other point of the line
     * @param a point to which the distance is calculated
     * @return distance between a point and a line
     */
    public static double calcDistanceToLine(Point l1, Point l2, Point a){
        return Math.abs((l2.getX() - l1.getX()) * (l1.getY() - a.getY()) - (l1.getX() - a.getX()) * (l2.getY() - l1.getY()))
                            / Math.sqrt(Math.pow((l2.getX() - l1.getX()),2) + Math.pow((l2.getY() - l1.getY()),2));
    }

  /**
     * Calculate the smallest radius of the circle including three points p1, p2, p3
     * @param p1 Point
     * @return (double) the smallest radius of the circle including by three points
     */
    public static double calCircleByPoints(Point p1, Point p2, Point p3) {
        if (compareDoublePara(isTriangleArea(p1, p2, p3), 0 ) == 0) {
            // if they are collinear, the smallest radius to include all points is
            // the largest distance between two of three points
            double dis1 = calDistance(p1, p2);
            double dis2 = calDistance(p1, p3);
            double dis3 = calDistance(p2, p3);
            double maxDis = Math.max(dis1, dis2);
            maxDis = Math.max(maxDis, dis3);
            return maxDis / 2;
        }
        // if they form a triangle
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double cal1 = ((x1 * x1 -x3 * x3) * (x1 - x2)
                + (y1 * y1 - y3 * y3) * (x1 - x2)
                + (x2 * x2 - x1 * x1) * (x1 - x3)
                + (y2 * y2 - y1 * y1) * (x1 - x3))
                / (2 * ((y3 - y1) * (x1 - x2) - (y2 - y1) * (x1 - x3)));
        double cal2 = ((x1 * x1 -x3 * x3) * (y1 - y2)
                + (y1 * y1 - y3 * y3) * (y1 - y2)
                + (x2 * x2 - x1 * x1) * (y1 - y3)
                + (y2 * y2 - y1 * y1) * (y1 - y3))
                / (2 * ((x3 - x1) * (y1 - y2) - (x2 - x1) * (y1 - y3)));
        double cal3 = - x1 * x1 - y1 * y1 - 2 * cal2 * x1 - 2 * cal1 * y1;

        return Math.sqrt(cal1 * cal1 + cal2 * cal2 - cal3);
    }

    /**
     * Compare two double parameters
     * @param x double
     * @param y double
     * @return 0 if equal, 1 if x > y, -1 if x < y
     */
    public static int compareDoublePara(double x, double y) {
        if (Math.abs(x - y) < 0.000001) return 0;
        if (x > y) return 1;
        return -1;
    }

}
