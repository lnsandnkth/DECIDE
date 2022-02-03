package ConditionTests;

import com.example.LICs.LIC5;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIC5Test {

    @Test
    @DisplayName("LIC5 Test: should return true if there are two consecutive points with a delta X < 0")
    public void LIC5Test() {

        List<Point> positiveList = Arrays.asList(
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(4, 0),
            new Point(5, 0),
            new Point(4, 0),
            new Point(7, 0)
                                                );

        List<Point> negativeList = Arrays.asList(
            new Point(1, 0),
            new Point(2, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(5, 0),
            new Point(5, 0),
            new Point(6, 0)
                                                );

        Assertions.assertAll(
            () -> Assertions.assertFalse(LIC5.LIC5(new ArrayList<>())),
            () -> Assertions.assertTrue(LIC5.LIC5(positiveList)),
            () -> Assertions.assertFalse(LIC5.LIC5(negativeList))
                            );
    }
}
