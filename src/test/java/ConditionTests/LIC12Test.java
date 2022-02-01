package ConditionTests;

import com.example.LICs.*;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC12Test {
    @Test
    @DisplayName("LIC12 Test: should return true if there exists at least one set of two data points, separated by exactly K_PTS consecutive" +
            " intervening points, which are a distance greater than the length LENGTH1;" +
            " another (or the same) set of two points must have a smaller distance than LENGTH2")
    public void LIC12Test() {
        List<Point> positiveList = Arrays.asList(
            new Point(6, 5),
            new Point(7, 2),
            new Point(5, 6),
            new Point(4, 1),
            new Point(0, 5),
            new Point(4, 5),
            new Point(3, 0),
            new Point(4, 2),
            new Point(2, 6),
            new Point(8, 9)
            );

        List<Point> negativeList = Arrays.asList(
            new Point(2, 3),
            new Point(3, 4),
            new Point(5, 1),
            new Point(5, 6),
            new Point(6, 8),
            new Point(2, 6),
            new Point(2, 0),
            new Point(8, 2),
            new Point(5, 0),
            new Point(2, 2)
        );

        List<Point> negativeList2 = Arrays.asList(
                new Point(2, 3),
                new Point(3, 4)
        );

        Assertions.assertAll(
                () -> Assertions.assertTrue(LIC12.LIC12(positiveList,1,2.5,2.5)),
                () -> Assertions.assertFalse(LIC12.LIC12(negativeList,2,50,0.05)),
                () -> Assertions.assertFalse(LIC12.LIC12(negativeList2,1,2,1))
        );
    }
}
