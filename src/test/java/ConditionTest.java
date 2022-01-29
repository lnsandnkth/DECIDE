import com.example.ConditionCheck;
import com.example.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ConditionTest {
    private ConditionCheck conditionCheck;

    @BeforeEach
    public void initial() {
        conditionCheck = new ConditionCheck();
    }

    @Test
    public void LIC0Test() {
        List<Point> points = List.of(new Point(1, 5), new Point(3.2, 7));
        double length1 = 2.5;
        boolean res = conditionCheck.LIC0(points, length1);
        assert (res);
    }
      
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
            () -> Assertions.assertTrue(ConditionCheck.LIC1(positiveList, 5)),
            () -> Assertions.assertFalse(ConditionCheck.LIC1(negativeList, 5))
        );

    }

    @Test

    public void LIC2Test() {
        List<Point> positiveOutComePointList = List.of(new Point(4, 5), new Point(1, 1), new Point(1,5));
        float positiveEpsilon = 10;
        boolean res1 = conditionCheck.LIC2(positiveOutComePointList, positiveEpsilon);

        List<Point> negativeOutComePointList = List.of(new Point(4, 5), new Point(1, 5), new Point(1,1));
        float negativeEpsilon = 90;
        boolean res2 = conditionCheck.LIC2(negativeOutComePointList, negativeEpsilon);

        List<Point> secondPositiveOutComePointList = List.of(new Point(4, 5), new Point(1, 5),
                new Point(1,1),new Point(4, 5), new Point(1, 1), new Point(1,5));
        boolean res3 = conditionCheck.LIC2(secondPositiveOutComePointList,negativeEpsilon);

        Assertions.assertTrue(res1);
        Assertions.assertFalse(res2);
        Assertions.assertTrue(res3);
    }



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
            () -> Assertions.assertTrue(ConditionCheck.LIC3(positiveList, 2)),
            () -> Assertions.assertFalse(ConditionCheck.LIC3(negativeList, 2))
        );
    }

}
