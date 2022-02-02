package ConditionTests;

import com.example.LICs.*;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class LIC4Test {

    @Test
    @DisplayName("LIC4 Test: should return true if there are Q_PTS consecutive points in more than QUADS quadrants")
    public void LIC4Test() {
        List<Point> list = Arrays.asList(
            new Point(1, 1),
            new Point(1, 1),
            new Point(1, -1),
            new Point(1, -1),
            new Point(-1, -1),
            new Point(-1, 1),
            new Point(1, -1)
                                                );

        // Positive tests
        Assertions.assertAll(
            () -> Assertions.assertTrue(LIC4.LIC4(list, 2, 1)),
            () -> Assertions.assertTrue(LIC4.LIC4(list, 3, 2))
                            );

        // Negative tests
        Assertions.assertAll(
            () -> Assertions.assertFalse(LIC4.LIC4(list, 1, 1)), // Q PTS < 2
            () -> Assertions.assertFalse(LIC4.LIC4(list, list.size() + 1, 1)), // Q PTS > NUMPOINTS
            () -> Assertions.assertFalse(LIC4.LIC4(list, 2, 0)), // QUADS < 1
            () -> Assertions.assertFalse(LIC4.LIC4(list, 2, 4)), // QUADS > 3

            () -> Assertions.assertFalse(LIC4.LIC4(list, 2, 2)),
            () -> Assertions.assertFalse(LIC4.LIC4(list, 4, 3))
                            );
    }
}
