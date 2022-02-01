package com.example;

import com.example.utils.LogicEnum;

import com.example.LICs.*;
import com.example.utils.Point;

import java.util.List;

public class ConditionCheck {

    /**
     * Calculates Preliminary Unlocking Matrix (PUM), every element of the boolean PUM corresponds to an element of the LCM
     * @param CMV Conditions Met Vector, based on LIC calculation
     * @param LCM Logical Connector Matrix, describes how individual LIC's should be logically combined
     * @throws IllegalArgumentException check CMV and LCM
     * @return (boolean[][]) PUM, a 15x15 symmetric matrix
     */
    public static boolean[][] calcPUM(boolean[] CMV, LogicEnum[][] LCM) throws IllegalArgumentException {
        if (CMV.length != LCM.length) throw new IllegalArgumentException("CMV and LCM entries number should match");
        int num = LCM.length;
        boolean[][] PUM = new boolean[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j) {
                    PUM[i][j] = true;
                } else {
                    PUM[i][j] = calcEntry(CMV[i], CMV[j], LCM[i][j]);
                }
            }
        }
        return PUM;
    }

    /**
     * Calculates one entry for PUM based on CMV[i] and CMV[j] with operator determined by LCM[i, j]
     * @param iCMV CMV[i]
     * @param jCMV CMV[j]
     * @param ijLCM LCM[i, j]
     * @return (boolean) PUM[i, j]
     */
    public static boolean calcEntry(boolean iCMV, boolean jCMV, LogicEnum ijLCM) {
        return switch (ijLCM) {
            case NOTUSED -> true;
            case ANDD -> iCMV && jCMV;
            case ORR -> iCMV || jCMV;
        };
    }

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

    public static boolean[] makeFUV(boolean[][] PUM, boolean[] PUV) {

        boolean[] FUV = new boolean[PUV.length];
        for (int i = 0; i < FUV.length; i++) {
            FUV[i] = !PUV[i] || makeFUVEntry(PUM, i);
        }

        return FUV;
    }

    private static boolean makeFUVEntry(boolean[][] PUM, int n) {

        for (int i = 0; i < PUM[n].length; i++)
            if(i != n && !PUM[n][i]) return false;

        return true;
    }
}
