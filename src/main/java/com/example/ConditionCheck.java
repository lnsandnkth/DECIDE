package com.example;

import com.example.LICs.*;
import com.example.utils.Point;

import java.util.List;

public class ConditionCheck {

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
