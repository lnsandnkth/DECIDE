package ConditionTests;

import com.example.LICs.LIC0;
import com.example.LICs.LIC1;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC0Test {
    @Test
    @DisplayName("LIC0 Test: There exists at least one set of two consecutive data points that are a distance greater than the length, LENGTH1, apart.")
    public void LIC0Test() {
        List<Point> points = Arrays.asList(new Point(1, 5), new Point(3.2, 7));
        double length1 = 2.5;
        boolean res = LIC0.LIC0(points, length1);
        assert (res);
    }
}
