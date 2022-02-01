package ConditionTests;

import com.example.LICs.LIC3;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC3Test {

    @Test
    @DisplayName("LIC3 Test: return true if exists three consecutive points form a triangle with are greater than area1")
    public void LIC3Test() {

        List<Point> positiveList = Arrays.asList(
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(3, 1),
            new Point(4, 0),
            new Point(6, 0),
            new Point(5, 5),
            new Point(0, 0)
                                                );

        List<Point> negativeList = Arrays.asList(
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(3, 1),
            new Point(4, 0),
            new Point(6, 0)
                                                );

        Assertions.assertAll(
            () -> Assertions.assertFalse(LIC3.LIC3(positiveList, -1)),
            () -> Assertions.assertTrue(LIC3.LIC3(positiveList, 2)),
            () -> Assertions.assertFalse(LIC3.LIC3(negativeList, 2))
                            );
    }
}
