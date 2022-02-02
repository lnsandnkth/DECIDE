package ConditionTests;

import com.example.ConditionCheck;
import com.example.LICs.*;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class LIC11Test {
    @Test
    @DisplayName("LIC11 Test: should return true if there exists a set of two points, that are seperated by exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0 (i<j)")
    public void LIC11Test() {
        List<Point> positiveList = Arrays.asList(
                new Point(5, 0),
                new Point(3, 0),
                new Point(8, 0),
                new Point(3, 0),
                new Point(8, 0),
                new Point(8, 0),
                new Point(5, 0)
        );

        List<Point> negativeList = Arrays.asList(
                new Point(5, 0),
                new Point(4, 0)
        );

        List<Point> negativeList2 = Arrays.asList(
                new Point(5, 0),
                new Point(3, 0),
                new Point(8, 0),
                new Point(3, 0),
                new Point(8, 0),
                new Point(8, 0),
                new Point(9, 0)
        );

        Assertions.assertAll(
                () -> Assertions.assertTrue(LIC11.LIC11(positiveList, 3)),
                () -> Assertions.assertFalse(LIC11.LIC11(negativeList2, 3)),
                () -> Assertions.assertFalse(LIC11.LIC11(negativeList, 1))
        );
    }
}
