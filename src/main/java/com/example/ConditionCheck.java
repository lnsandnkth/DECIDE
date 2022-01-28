package com.example;

public class ConditionCheck {

    /**
     * Computes the distance between two points
     * @param p1 first Point
     * @param p2 second Point
     * @see Point
     * @return (double) distance between p1 and p2
     */
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

}
