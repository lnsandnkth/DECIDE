package com.example;

import com.example.LICs.*;
import com.example.utils.Point;

import java.util.List;

public class ConditionCheck {

    /**
     * Makes a CMV vector by applying the 15 different LICs to the point list with the given parameters
     * @param points input points of the program
     * @param LENGTH1 parameter for LIC0
     * @param RADIUS1 parameter for LIC1
     * @param EPSILON parameter for LIC2
     * @param AREA1 parameter for LIC3
     * @param Q_PTS parameter for LIC4
     * @param QUADS parameter for LIC5
     * @return a CMV vector (result of the 15 LICs)
     */
    public static boolean[] makeCMV(List<Point> points,
                                    double LENGTH1,
                                    double RADIUS1,
                                    double EPSILON,
                                    double AREA1,
                                    int Q_PTS,
                                    int QUADS
                                    ) {

        return new boolean[] {
            LIC0.LIC0(points, LENGTH1),
            LIC1.LIC1(points, RADIUS1),
            LIC2.LIC2(points, EPSILON),
            LIC3.LIC3(points, AREA1),
            LIC4.LIC4(points, Q_PTS, QUADS),
            LIC5.LIC5(points),
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false,  // TODO missing LIC
            false   // TODO missing LIC
        };
    }
}
