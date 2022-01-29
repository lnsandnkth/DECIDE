import com.example.ConditionCheck;
import com.example.Point;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.function.BiFunction;

public class MathTest {

    @Test
    @Order(1)
    @DisplayName("calDistance : distance between two points p1 and p2")
    public void calDistanceTest() {

        Assertions.assertAll(
            () -> Assertions.assertEquals(0, ConditionCheck.calDistance(new Point(10, 10), new Point(10, 10))),
            () -> Assertions.assertEquals(2, ConditionCheck.calDistance(new Point(1, 1), new Point(1, 3))),
            () -> Assertions.assertEquals(2, ConditionCheck.calDistance(new Point(-1, 0), new Point(-3, 0)))
                            );
    }

    @Test
    @DisplayName("calNorm : length of vector")
    public void calNormTest() {

        BiFunction<Double, Point, Executable> distTest = (expected, point) -> () -> Assertions.assertEquals(expected, ConditionCheck.calNorm(point));

        Assertions.assertAll(
            distTest.apply(0d, new Point(0, 0)),
            distTest.apply(1d, new Point(0, 1)),
            distTest.apply(1d, new Point(-1, 0)),
            distTest.apply(5d, new Point(3, -4))
                            );
    }

    @Test
    @DisplayName("isInsideCircle : check if a Point is in a circle")
    public void insideCircleTest() {

        BiFunction<Point, Double, Executable> insideTest = (point, radius) -> () -> Assertions.assertTrue(ConditionCheck.isInCircle(point, radius));
        BiFunction<Point, Double, Executable> outsideTest = (point, radius) -> () -> Assertions.assertFalse(ConditionCheck.isInCircle(point, radius));

        Assertions.assertAll(
            insideTest.apply(new Point(0, 0), 1d),
            insideTest.apply(new Point(0, 0), 0d),
            insideTest.apply(new Point(0, 1), 1d),
            outsideTest.apply(new Point(2, 1), 1d),
            outsideTest.apply(new Point(-2, -2), 2d),
            outsideTest.apply(new Point(0, 1), 0d)
                            );
    }


    @Test
    @DisplayName("isTriangleArea: calculate area of triangle")
    public void isTriangleAreaTest() {

        Assertions.assertAll(
            () -> Assertions.assertEquals(3, ConditionCheck.isTriangleArea(new Point(0, 0), new Point(3, 0), new Point(0, 2))),
            () -> Assertions.assertEquals(0, ConditionCheck.isTriangleArea(new Point(0, 1), new Point(0, 3), new Point(0, 2))),
            () -> Assertions.assertEquals(10, ConditionCheck.isTriangleArea(new Point(-5, 0), new Point(5, 0), new Point(0, 2)))
        );
    }

}
