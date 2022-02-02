package com.example;
import com.example.utils.CONNECTORS;
import com.example.utils.PARAMETERS_T;
import com.example.utils.Point;

import java.util.Arrays;
import java.util.List;


public class Main {

    // Input Variables
    public List<Point> points;
    public PARAMETERS_T parameters_t;
    public CONNECTORS[][] LCM;
    public boolean[] PUV;

    // Output Variables
    public boolean launch;
    public boolean[] CMV;
    public boolean[][] PUM;
    public boolean[] FUV;

    // Initialize
    public Main(PARAMETERS_T parameters, List<Point> points, CONNECTORS[][] LCM, boolean[] PUV) {
        this.points = points;
        this.parameters_t = parameters;
        this.LCM = LCM;
        this.PUV = PUV;
    }

    /**
     * Generate a boolean signal which determines whether an interceptor should be launched
     * based upon input radar tracking information
     */
    public boolean DECIDE() {
        this.CMV = ConditionCheck.makeCMV(points, parameters_t);
        this.PUM = ConditionCheck.calcPUM(CMV, this.LCM);
        this.FUV = ConditionCheck.makeFUV(this.PUM, this.PUV);
        this.launch = ConditionCheck.checkFUV(this.FUV);
        if (this.launch) System.out.println("YES");
        else System.out.println("NO");
        return this.launch;
    }

}
