package com.example.LICs;

import com.example.utils.MathFunctions;
import com.example.utils.Point;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LIC4 {

    public static boolean LIC4(List<Point> points, int Q_PTS, int QUADS) {

        Set<Integer> quadrants = new TreeSet<>();

        // for each point
        for (int i = Q_PTS - 1; i < points.size(); i++) {

            // check previous Q_PTS points
            for (int j = 0; j < Q_PTS; j++) {

                int quadrant = MathFunctions.calcQuadrant(points.get(i-j));
                quadrants.add(quadrant);
            }

            if (quadrants.size() > QUADS) {
                return true;
            }

            quadrants.clear();
        }

        return false;
    }
}
