package com.example.LICs;

import com.example.utils.*;
import java.util.List;

public class LIC9 {

    /**
     * @param points a list of data points to check the condition on
     * @param epsilon the value for the deviation in angle from pi
     * @param C_PTS the number of points between point 1 and point 2
     * @param D_PTS the number of points between point 2 and point 3
     * @return true if condition LIC9 is satisfied, false otherwise
     */
    public static boolean LIC9(List<Point> points, double epsilon, int C_PTS, int D_PTS){
        if(points.size() < 5 || C_PTS < 1 || D_PTS < 1){
            return false;
        }
        if(points.size() - C_PTS - D_PTS - 2 <= 0) {
            return false;
        }
        // assuming point1 and point 2 separated by C_PTS and point 2 and 3 separated by D_PTS
        for(int i = 0; i < points.size() - C_PTS - D_PTS - 2; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + C_PTS + 1);
            Point p3 = points.get(i + C_PTS + D_PTS + 2);

            double angle = MathFunctions.calcAngleInPoint2(p1, p2, p3);
            if(angle < (180 - epsilon) || angle > (180 + epsilon)) {
                return true;
            }
        }
        return false;
    }
}
