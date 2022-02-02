package ConditionTests;

import com.example.LICs.*;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class LIC6Test {
    @Test
    @DisplayName("LIC6 Test: should return true if the first and last points" +
            " of a set of points from i to j (j=i+NPTS) have a greater distance than DIST")
    public void LIC6Test() {
        List<Point> positiveList = Arrays.asList(
            new Point(0, 2),
            new Point(8, 8),
            new Point(7, 0),
            new Point(2, 8),
            new Point(5, 4),
            new Point(8, 8),
            new Point(9, 0),
            new Point(1, 7),
            new Point(3, 3),
            new Point(4, 6)
        );

        List<Point> negativeList = Arrays.asList(
            new Point(8, 5),
            new Point(1, 5),
            new Point(6, 8),
            new Point(7, 5),
            new Point(7, 5),
            new Point(8, 1),
            new Point(5, 8),
            new Point(7, 0),
            new Point(5, 5),
            new Point(2, 2)
        );

        List<Point> negativeList2 = Arrays.asList(
                new Point(8, 5),
                new Point(1, 5)
        );

        List<Point> negativeList3 = Arrays.asList(
                new Point(8, 5),
                new Point(8, 5),
                new Point(8, 5),
                new Point(8, 5),
                new Point(8, 5),
                new Point(8, 5),
                new Point(8, 5),
                new Point(8, 5)
        );

        Assertions.assertAll(
                () -> Assertions.assertTrue(LIC6.LIC6(positiveList,4,1.5)),
                () -> Assertions.assertFalse(LIC6.LIC6(negativeList,4,50)),
                () -> Assertions.assertFalse(LIC6.LIC6(negativeList2,2,-0.5)),
                () -> Assertions.assertFalse(LIC6.LIC6(negativeList3,4,5))
        );
    }
}
