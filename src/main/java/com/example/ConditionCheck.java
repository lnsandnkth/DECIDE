package com.example;

import com.example.LICs.*;
import com.example.utils.PARAMETERS_T;
import com.example.utils.Point;
import com.example.utils.CONNECTORS;

import java.util.List;

public class ConditionCheck {

    /**
     * Calculates Preliminary Unlocking Matrix (PUM), every element of the boolean PUM corresponds to an element of the LCM
     * @param CMV Conditions Met Vector, based on LIC calculation
     * @param LCM Logical Connector Matrix, describes how individual LIC's should be logically combined
     * @throws IllegalArgumentException check CMV and LCM
     * @return (boolean[][]) PUM, a 15x15 symmetric matrix
     */
    public static boolean[][] calcPUM(boolean[] CMV, CONNECTORS[][] LCM) throws IllegalArgumentException {
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
    public static boolean calcEntry(boolean iCMV, boolean jCMV, CONNECTORS ijLCM) {
        return switch (ijLCM) {
            case NOTUSED -> true;
            case ANDD -> iCMV && jCMV;
            case ORR -> iCMV || jCMV;
        };
    }

    /**
     * Makes a CMV vector by applying the 15 different LICs to the point list with the given parameters
     * @param points input points of the program
     * @param parameters parameters for LICs
     * @return a CMV vector (result of the 15 LICs)
     */
    public static boolean[] makeCMV(List<Point> points, PARAMETERS_T parameters) {

        return new boolean[] {
            LIC0.LIC0(points, parameters.LENGTH1),
            LIC1.LIC1(points, parameters.RADIUS1),
            LIC2.LIC2(points, parameters.EPSILON),
            LIC3.LIC3(points, parameters.AREA1),
            LIC4.LIC4(points, parameters.Q_PTS, parameters.QUADS),
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
