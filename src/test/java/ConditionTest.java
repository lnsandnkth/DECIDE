import com.example.Point;
import com.example.ConditionCheck;
import org.junit.jupiter.api.Assertions;
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
        assert(res);
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


}
