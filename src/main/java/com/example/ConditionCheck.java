package com.example;

import com.example.utils.LogicEnum;

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
}
