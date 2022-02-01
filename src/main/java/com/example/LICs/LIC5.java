package com.example.LICs;

import java.util.List;
import com.example.utils.*;

public class LIC5 {

    /**
     * LIC5 - Launch Interceptor Condition #5
     * Checks if there is at least one pair of consecutive points in the list with a negative X coordinate difference
     * @param points list of points to check
     * @return true if two consecutive points have a negative delta X
     */
    public static boolean LIC5(List<Point> points) {

        if (points.size() < 2)
            return false;

        for (int i = 1; i < points.size(); i++)
            if (points.get(i).getX() - points.get(i-1).getX() < 0)
                return true;

        return false;
    }
}
