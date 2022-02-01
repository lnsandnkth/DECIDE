package ConditionTests;

import com.example.LICs.LIC2;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC2Test {
    @Test
    @DisplayName("LIC2 Test: ")
    public void LIC2Test() {
        List<Point> positiveOutComePointList = Arrays.asList(new Point(4, 5), new Point(1, 1), new Point(1,5));
        float positiveEpsilon = (float) Math.toRadians(10);
        boolean res1 = LIC2.LIC2(positiveOutComePointList, positiveEpsilon);

        List<Point> negativeOutComePointList = Arrays.asList(new Point(4, 5), new Point(1, 5), new Point(1,1));
        float negativeEpsilon = (float) Math.toRadians(90);
        float secondPositiveEpsilon = (float) Math.toRadians(80);
        boolean res2 = LIC2.LIC2(negativeOutComePointList, negativeEpsilon);

        List<Point> secondPositiveOutComePointList = Arrays.asList(new Point(4, 5), new Point(1, 5),
                new Point(1,1),new Point(4, 5), new Point(1, 1), new Point(1,5));
        boolean res3 = LIC2.LIC2(secondPositiveOutComePointList,secondPositiveEpsilon);

        Assertions.assertAll(
            () -> Assertions.assertFalse(LIC2.LIC2(positiveOutComePointList, -1)),
            () -> Assertions.assertFalse(LIC2.LIC2(positiveOutComePointList, (float) (2 * Math.PI))),
            () -> Assertions.assertTrue(res1),
            () -> Assertions.assertFalse(res2),
            () -> Assertions.assertTrue(res3)
                            );
    }
}
