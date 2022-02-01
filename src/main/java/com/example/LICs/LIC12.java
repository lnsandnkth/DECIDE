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
     * @return true if two consecutive points have a negative delta X
     */
    public static boolean LIC12(List<Point> points, int K_PTS, double LENGTH1,double LENGTH2) {
        if (points.size() < 3 || LENGTH2 < 0) {
            return false;
        }
        for (int i = 0; i < points.size() - K_PTS; i++) {
            if (MathFunctions.calDistance(points.get(i), points.get(i + K_PTS)) > LENGTH1){
                return true;
            }
        }
        return false;
    }
}
