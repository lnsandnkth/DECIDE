package ConditionTests;

import com.example.LICs.LIC1;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC1Test {

    @Test
    @DisplayName("LIC1 Test: should return true if input list contains 3 consecutive points inside a circle")
    public void LIC1Test() {

        List<Point> positiveList = Arrays.asList(
            new Point(1, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(7, 0),
            new Point(6, 0),
            new Point(8, 0),
            new Point(0, 0),
            new Point(0, 0)
                                                );

        List<Point> negativeList = Arrays.asList(
            new Point(5, 0),
            new Point(6, 0),
            new Point(4, 0),
            new Point(2, 0),
            new Point(8, 0)
                                                );

        Assertions.assertAll(
            () -> Assertions.assertFalse(LIC1.LIC1(positiveList, -1)),
            () -> Assertions.assertTrue(LIC1.LIC1(positiveList, 5)),
            () -> Assertions.assertFalse(LIC1.LIC1(negativeList, 5))
                            );
    }
}
