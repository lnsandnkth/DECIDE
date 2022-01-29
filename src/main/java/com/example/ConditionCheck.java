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
            if (!isInCircle(point, radius)) {
                consecutive++;
                max_consecutive = Math.max(consecutive, max_consecutive);
            } else
                consecutive = 0;
        }

        return max_consecutive >= 3;
    }



    /**
     * LIC3 - Launch Interceptor Condition #3
     * Checks if exists a triangle(formed by three consecutive data points) with area greater than area1.
     * @param points List<Point> list of points to iterate on
     * @param area1 the area to compare with
     * @return (boolean) true is there exists such triangle
     */
    public static boolean LIC3(List<Point> points, double area1) throws IllegalArgumentException {
        if (area1 < 0) {
            throw new IllegalArgumentException("Area should not be less than zero");
        }
        if (points.size() < 3) {
            throw new IllegalArgumentException("There should be at least three points");
        }
        for (int i = 0; i < points.size() - 2; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            Point p3 = points.get(i + 2);
            if (isTriangleArea(p1, p2, p3) - area1 > 0.000001) return true;
        }
        return false;
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
}
