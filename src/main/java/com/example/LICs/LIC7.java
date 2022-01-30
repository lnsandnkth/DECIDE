package com.example.LICs;

import com.example.utils.Point;
import com.example.utils.MathFunctions;
import java.util.List;

public class LIC7 {

    /**
     * @param points list of points to check
     * @param K_PTS the number of points that the set of two points should be separated by
     * @param LENGTH1 the length that the set of two points distance from each other should be greater than
     * @return True if there exists at least one set of two points that are at a greater distance than LENGTH1, false otherwise
     */
    public static boolean LIC7(List<Point> points, int K_PTS, double LENGTH1) {
        if(K_PTS < 1) {
            return false;
        }
        if((points.size() - 2) < K_PTS) {
            return false;
        }

        for(int i = 0; i < points.size() - K_PTS; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + K_PTS);
            if(MathFunctions.calDistance(p1, p2) > LENGTH1){
                return true;
            }
        }

        return false;
    }
}
