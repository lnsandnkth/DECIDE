package ConditionTests;

import com.example.LICs.LIC13;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC13Test {

    @Test
    @DisplayName("LIC13 returning true test")
    public void LIC13TestTrue() {
        List<Point> positiveOutComePointList = Arrays.asList(
                new Point(0, 1),
                new Point(70, 26),
                new Point(157, 62),
                new Point(60, 90),
                new Point(0, 2),
                new Point(5, 16),
                new Point(11, 26),
                new Point(13, 26),
                new Point(14, 26),
                new Point(1, 2),
                new Point(5, 5));
        double radius_1 = 7;
        boolean res1 = LIC13.LIC13(positiveOutComePointList, 3, 4, 0.5, 2.5);

        Assertions.assertTrue(res1);
    }

    @Test
    @DisplayName("LIC13 returning false test")
    public void LIC13TestFalse() {
        List<Point> positiveOutComePointList = Arrays.asList(
                new Point(0, 1),
                new Point(70, 26),
                new Point(157, 62),
                new Point(60, 90),
                new Point(0, 2),
                new Point(5, 16),
                new Point(11, 26),
                new Point(13, 26),
                new Point(14, 26),
                new Point(1, 2),
                new Point(5, 5));
        boolean res1 = LIC13.LIC13(positiveOutComePointList, 3, 4, 2.5, 0.5);

        Assertions.assertFalse(res1);
    }

    @Test
    @DisplayName("LIC13 returning true test for a larger list")
    public void LIC13TestTrueInRelativelyLargeList() {
        List<Point> positiveOutComePointList = Arrays.asList(
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(70, 26),
                new Point(157, 62),
                new Point(0, 1),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 90),
                new Point(60, 9440),
                new Point(60, 90),
                new Point(0, 2),
                new Point(5, 16),
                new Point(11, 26),
                new Point(13, 26),
                new Point(14, 26),
                new Point(19, 552),
                new Point(1, 2));

        boolean res1 = LIC13.LIC13(positiveOutComePointList, 10, 5, 0.5, 2);

        Assertions.assertTrue(res1);
    }

    @Test
    @DisplayName("LIC13 not enough points test")
    public void NotEnoughPoints() {

        List<Point> points = Arrays.asList(
            new Point(1, 0),
            new Point(1, 0),
            new Point(1, 0)
                                          );

        Assertions.assertFalse(LIC13.LIC13(points, 3, 4, .5, 2.5));
    }

    @Test
    @DisplayName("LIC13 negative radius2")
    public void NegativeRadius2Test() {

        List<Point> points = Arrays.asList(
            new Point(1, 0),
            new Point(1, 0),
            new Point(1, 0),
            new Point(1, 0),
            new Point(1, 0),
            new Point(1, 0)
                                          );

        Assertions.assertFalse(LIC13.LIC13(points, 3, 4, .5, -1));
    }
}
