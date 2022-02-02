package com.example.LICs;

import com.example.utils.MathFunctions;
import com.example.utils.Point;

import java.util.List;

public class LIC13 {
    /**
     * Helper function that evaluates if three points in a list of points
     * with consecutive intervening points are contained withing a circle
     *
     * @param radius The radius of the circle
     * @param points The list of points
     * @param a_pts  Consecutive intervening points between first point and second point
     * @param b_pts  Consecutive intervening points between second point and third point
     * @return false if they are contained, true if they are not contained.
     */
    public static boolean threePointFromListContainedInRadiusCheck(double radius, List<Point> points, int a_pts, int b_pts) {
        int currentIndex = 0;
        while ((points.size()) - currentIndex > (a_pts + b_pts + 2)) {
            Point firstPoint = points.get(currentIndex);
            Point secondPoint = points.get(currentIndex + a_pts + 1);
            Point thirdPoint = points.get(currentIndex + a_pts + b_pts + 2);
            double smallestRadius = MathFunctions.calCircleByPoints(firstPoint, secondPoint, thirdPoint);
            if (smallestRadius<=radius) {
                return false;
            }
            currentIndex++;
        }
        return true;
    }

    /**
     * LIC13 - Evaluate if there exists three points in the list of points
     * that are not contained within a specific radius and if there exists three points
     * in the list that are contained within a different radius.
     *
     * @param points   List of Point object.
     * @param a_pts    Consecutive intervening points between first point and second point
     * @param b_pts    Consecutive intervening points between second point and third point
     * @param RADIUS_1 First radius.
     * @param RADIUS_2 Second radius.
     * @return If condition is met, return true, otherwise return 0
     */
    public static boolean LIC13(List<Point> points, int a_pts, int b_pts, double RADIUS_1, double RADIUS_2) {
        if (points.size() < 5 || !(RADIUS_2 >= 0)) {
            return false;
        }
        return threePointFromListContainedInRadiusCheck(RADIUS_1, points, a_pts, b_pts)
                && !threePointFromListContainedInRadiusCheck(RADIUS_2, points, a_pts, b_pts);

    }
}
