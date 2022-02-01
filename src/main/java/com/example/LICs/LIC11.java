package com.example.LICs;

import com.example.utils.Point;
import java.util.List;
import com.example.utils.*;

public class LIC11 {

    /**
     * LIC11 - Launch Interceptor Condition #11
     * Checks if there is at least one set of two points (X[i],Y[i]) and (X[j],Y[j]), separated by exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0. (where i < j )
     * @param points list of points to check
     * @param G_PTS number of consecutive intervening points between the set of points, i and j
     * @return true if there exists a set of two points, that are seperated by exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0 (i<j)
     */
    public static boolean LIC11(List<Point> points, int G_PTS) {
        if (points.size() < 3 || G_PTS < 1 || G_PTS > points.size()-2) {
            return false;
        }

        for (int i = 0, j = 1 + G_PTS; j < points.size(); i++, j++){
            if (points.get(j).getX() - points.get(i).getX() < 0){
                return true;
            }
        }
        return false;
    }
}
