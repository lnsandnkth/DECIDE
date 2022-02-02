package com.example.LICs;

import java.util.List;
import com.example.utils.*;

public class LIC12 {

    /**
     * LIC12 - Launch Interceptor Condition #12
     * Checks if there exists at least one set of two data points, separated by exactly K_PTS consecutive
     *      intervening points, which are a distance greater than the length LENGTH1;
     *      another (or the same) set of two points must have a smaller distance than LENGTH2
     * @param points list of points to check
     * @param K_PTS number of points between the first and last point of the set
     * @param LENGTH1 double; first length to check agains
     * @param LENGTH2 double; second length to check agains
     * @return true if two points have a distance bigger than LENGTH1,
     *      and two different or same points have a distance smaller than LENGTH2
     */
    public static boolean LIC12(List<Point> points, int K_PTS, double LENGTH1,double LENGTH2) {
        if (points.size() < 3 || LENGTH2 < 0) {
            return false;
        }
        boolean bigger_than_len1 = false;
        boolean smaller_than_len2 = false;
        for (int i = 0; i < points.size() - K_PTS - 1; i++) {
            if (MathFunctions.calDistance(points.get(i), points.get(i + K_PTS + 1)) > LENGTH1){
                bigger_than_len1 = true;
            }
            if (MathFunctions.calDistance(points.get(i), points.get(i + K_PTS + 1)) < LENGTH2){
                smaller_than_len2 = true;
            }
        }

        return bigger_than_len1 && smaller_than_len2;
    }
}
