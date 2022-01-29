import com.example.ConditionCheck;
import com.example.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import com.example.Point;
import com.example.ConditionCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
            () -> Assertions.assertTrue(ConditionCheck.LIC5(positiveList)),
            () -> Assertions.assertFalse(ConditionCheck.LIC5(negativeList))
        );
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
