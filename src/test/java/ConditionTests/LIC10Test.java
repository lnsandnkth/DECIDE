package ConditionTests;

import com.example.LICs.LIC10;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LIC10Test {

    @Test
    @DisplayName("LIC10 returning true test")
    public void LIC10TestTrue() {

        List<Point> positiveOutComePointList = Arrays.asList(
            new Point(1, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 5));
        float area = 7;
        boolean res1 = LIC10.LIC10(positiveOutComePointList, 4, 4, area);

        Assertions.assertTrue(res1);
    }

    @Test
    @DisplayName("LIC10 returning false test")
    public void LIC10TestFalse() {

        List<Point> positiveOutComePointList = Arrays.asList(
            new Point(1, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 5));
        float area = 9;
        boolean res1 = LIC10.LIC10(positiveOutComePointList, 4, 4, area);

        Assertions.assertFalse(res1);
    }


    @Test
    @DisplayName("LIC10 returning true where first point is not in the beginning of list")
    public void LIC10TestMoreElementsThan20True() {

        List<Point> positiveOutComePointList = Arrays.asList(

            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(50, 2),
            new Point(622, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 5));
        float area = 7;
        boolean res1 = LIC10.LIC10(positiveOutComePointList, 4, 4, area);

        Assertions.assertTrue(res1);
    }

    @Test
    @DisplayName("LIC10 returning false test for a list with more than 20 elements")
    public void LIC10TestMoreElementsThan20False() {

        List<Point> positiveOutComePointList = Arrays.asList(

            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(2, 1),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(5, 5));
        float area = 7;
        boolean res1 = LIC10.LIC10(positiveOutComePointList, 4, 4, area);

        Assertions.assertFalse(res1);
    }

    @Test
    @DisplayName("LIC10 not enough points test")
    public void NotEnoughPoints() {

        List<Point> notEnoughPointsList = Arrays.asList(
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2)
                                                            );

        Assertions.assertFalse(LIC10.LIC10(notEnoughPointsList, 2, 2, 0));
    }

    @Test
    @DisplayName("LIC10 with too small E_PTS parameter (< 1")
    public void TooSmallEPTS() {

        List<Point> somePointList = Arrays.asList(
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2)
                                                            );

        Assertions.assertFalse(LIC10.LIC10(somePointList, 0, 2, 0));
    }

    @Test
    @DisplayName("LIC10 with too small F_PTS parameter (< 1")
    public void TooSmallFPTS() {

        List<Point> somePointList = Arrays.asList(
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2)
                                                            );

        Assertions.assertFalse(LIC10.LIC10(somePointList, 2, 0, 0));
    }

    @Test
    @DisplayName("LIC10 with too big E_PTS and F_PTS combination")
    public void TooBigEorFPTS() {

        List<Point> somePointList = Arrays.asList(
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2),
            new Point(1, 2)
                                                            );

        Assertions.assertAll(
            () -> Assertions.assertFalse(LIC10.LIC10(somePointList, 10, 2, 0)),
            () -> Assertions.assertFalse(LIC10.LIC10(somePointList, 2, 10, 0))
                            );
    }
}
