package com.example.LICs;

import com.example.utils.MathFunctions;
import com.example.utils.Point;

import java.util.List;

public class LIC6 {
    /**
     * LIC6 - Launch Interceptor Condition #6
     * Checks if there exists at least one set of N_PTS consecutive data points such that at least one of the
     *      points lies a distance greater than DIST from the line joining the first and last of these N_PTS points
     * @param points list of points to check
     * @param N_PTS number of points
     * @param DIST double; distance to check against
     * @return true if there exists at least one set of N_PTS consecutive data points such that at least one of the
     *      points lies a distance greater than DIST from the line joining the first and last of these N_PTS points
     */
    public static boolean LIC6(List<Point> points, int N_PTS, double DIST) {
        if(points.size() < 3 || N_PTS < 3 || N_PTS > points.size() || DIST < 0){
            return false;
        }

        for (int i = 0; i < points.size() - N_PTS; i++) {
            if (MathFunctions.calDistance(points.get(i), points.get(i + N_PTS)) > DIST){
                return true;
            }
            if(points.get(i) == points.get(i + N_PTS)){
                double dist_to_all_others = 0.0d;
                for(int j = i+1;j < i + N_PTS; j++){
                    dist_to_all_others += MathFunctions.calDistance(points.get(i), points.get(j));
                }
                if(dist_to_all_others > DIST){
                    return true;
                }
            }
        }
        return false;
    }
}
