package com.example.LICs;

import com.example.utils.*;
import java.util.List;

public class LIC14 {

    public static boolean LIC14(List<Point> points, int E_PTS, int K_PTS, double AREA1, double AREA2) {
        boolean cond1 = false;
        boolean cond2 = false;
        if(points.size() < 5 || AREA2 < 0 || AREA1 < 0 || E_PTS < 1 || K_PTS < 1) return false;
        if(points.size() - K_PTS - E_PTS - 2 < 0) return false; // No explicit requirement for this but makes sense to have

        for(int i = 0; i < points.size() - E_PTS - K_PTS - 2; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + E_PTS + 1);
            Point p3 = points.get(i + E_PTS + K_PTS + 2);
            double area = Math.abs(MathFunctions.isTriangleArea(p1, p2, p3));
            if(area - AREA1 > 0.000001) cond1 = true;
            if(area - AREA2 < 0.000001) cond2 = true;
        }

        return cond1 && cond2;
    }
}
