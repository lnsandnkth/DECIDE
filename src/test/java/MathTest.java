import com.example.utils.Point;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import com.example.utils.MathFunctions;
import java.util.function.BiFunction;

import static java.lang.Math.PI;
import static java.lang.Math.exp;

public class MathTest {

    @Test
    @Order(1)
    @DisplayName("calDistance : distance between two points p1 and p2")
    public void calDistanceTest() {

        Assertions.assertAll(
            () -> Assertions.assertEquals(0, MathFunctions.calDistance(new Point(10, 10), new Point(10, 10))),
            () -> Assertions.assertEquals(2, MathFunctions.calDistance(new Point(1, 1), new Point(1, 3))),
            () -> Assertions.assertEquals(2, MathFunctions.calDistance(new Point(-1, 0), new Point(-3, 0)))
                            );
    }

    @Test
    @DisplayName("calNorm : length of vector")
    public void calNormTest() {

        BiFunction<Double, Point, Executable> distTest = (expected, point) -> () -> Assertions.assertEquals(expected, MathFunctions.calNorm(point));

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

        BiFunction<Point, Double, Executable> insideTest = (point, radius) -> () -> Assertions.assertTrue(MathFunctions.isInCircle(point, radius));
        BiFunction<Point, Double, Executable> outsideTest = (point, radius) -> () -> Assertions.assertFalse(MathFunctions.isInCircle(point, radius));

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
            () -> Assertions.assertEquals(3, MathFunctions.isTriangleArea(new Point(0, 0), new Point(3, 0), new Point(0, 2))),
            () -> Assertions.assertEquals(0, MathFunctions.isTriangleArea(new Point(0, 1), new Point(0, 3), new Point(0, 2))),
            () -> Assertions.assertEquals(10, MathFunctions.isTriangleArea(new Point(-5, 0), new Point(5, 0), new Point(0, 2)))
        );
    }

    @Test
    @DisplayName("calcPhase : calculate phase of a point ie angle in radian from vector (1,0) in counterclockwise direction")
    public void calcPhaseTest() {

        BiFunction<Double, Point, Executable> phaseTest = (expected, point) -> () -> {
            double phase = MathFunctions.calcPhase(point);
            System.out.println("Computing angle of (" + point.getX() + ", " + point.getY() + "), expected= " + expected + ", computed= " + phase);
            Assertions.assertEquals(expected, phase);
        };

        Assertions.assertAll(
            phaseTest.apply(0d, new Point(1, 0)),
            phaseTest.apply(PI/2, new Point(0, 1)),
            phaseTest.apply(PI, new Point(-1, 0)),
            phaseTest.apply(3*PI/2, new Point(0, -1))
                            );
    }

    @Test
    @DisplayName("calcQuadrant : calculate quadrant of a point (either of { 0, 1, 2, 3 } in counterclockwise direction)")
    public void calcQuadrantTest() {

        BiFunction<Integer, Point, Executable> quadrantTest = (expected, point) -> () -> {
            int quadrant = MathFunctions.calcQuadrant(point);
            System.out.println("Computing quadrant of (" + point.getX() + ", " + point.getY() + "), expected= " + expected + ", computed= " + quadrant);
            Assertions.assertEquals(expected, quadrant);
        };

        // Testing normal cases
        Assertions.assertAll(
            quadrantTest.apply(1, new Point(1, 1)),
            quadrantTest.apply(2, new Point(-1, 1)),
            quadrantTest.apply(3, new Point(-1, -1)),
            quadrantTest.apply(4, new Point(1, -1))
                            );

        // Testing edge cases
        Assertions.assertAll(
            quadrantTest.apply(1, new Point(1, 0)),
            quadrantTest.apply(1, new Point(0, 1)),
            quadrantTest.apply(2, new Point(-1, 0)),
            quadrantTest.apply(3, new Point(0, -1))
                            );
    }



}
