package ConditionTests;
import com.example.LICs.LIC8;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC8Test {
    @Test
    @DisplayName("LIC8 Test: test whether 3 points separated by exactly APt and BPts points respectively that can all be contained within or on a circle of radius1")
    public void LIC8Test() {
        List<Point> lessPoints = Arrays.asList(
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(3, 1)
        );
        List<Point> points = Arrays.asList(
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(3, 1),
                new Point(4, 0),
                new Point(6, 0),
                new Point(5, 5),
                new Point(3, -1)
        );
        // Normal conditions that meet the requirement
        Assertions.assertTrue(LIC8.LIC8(points, 2, 2, 0.5));
        Assertions.assertTrue(LIC8.LIC8(points, 3, 1, 1));
        // Conditions that do not have enough points
        Assertions.assertFalse(LIC8.LIC8(points, 6, 2, 2));
        Assertions.assertFalse(LIC8.LIC8(lessPoints, 6, 2, 2));
        // Normal conditions that do not meet the requirement
        Assertions.assertFalse(LIC8.LIC8(points, 2, 2, 6));
        Assertions.assertFalse(LIC8.LIC8(points, 1, 1, 6));

    }

}
