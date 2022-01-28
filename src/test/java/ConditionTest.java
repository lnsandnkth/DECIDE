import com.example.Point;
import com.example.ConditionCheck;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConditionTest {
    private ConditionCheck conditionCheck;

    @Test
    public void LIC0Test() {
        List<Point> points = List.of(new Point(1, 5), new Point(3.2, 7));
        double length1 = 2.5;
        boolean res = conditionCheck.LIC0(points, length1);
        assert(res);
    }
}
