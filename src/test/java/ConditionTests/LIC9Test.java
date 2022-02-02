package ConditionTests;

import com.example.LICs.LIC9;
import com.example.utils.Point;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LIC9Test {

    List<Point> list;

    @BeforeAll
    public void setUp() {

        list = Arrays.asList(
            new Point(1, -1),
            new Point(2, 7),
            new Point(8, -7),
            new Point(-6, 1),
            new Point(1, -1),
            new Point(-1, -3),
            new Point(8, 10),
            new Point(-8, 0),
            new Point(5, -6),
            new Point(9, -5));
    }

    @Test
    @DisplayName("Test LIC9 with not enough points")
    public void NotEnoughPointsTest() {

        Assertions.assertFalse(LIC9.LIC9(list.subList(0, 3), 0.01, 1, 1));
    }

    @Test
    @DisplayName("Test LIC9 for points.size() - C - D - 2 <= 0 condition")
    public void test() {

        Assertions.assertFalse(LIC9.LIC9(list.subList(0, 4), 0.01, 1, 2));
    }

    @Test
    @DisplayName("Test LIC9 for small epsilon")
    public void SmallEpsilonTest() {

        Assertions.assertTrue(LIC9.LIC9(list, 0.01, 2, 1));
    }

    @Test
    @DisplayName("Test LIC9 for large epsilon")
    public void LargeEpsilonTest() {

        Assertions.assertFalse(LIC9.LIC9(list, 10000, 2, 1));
    }

    @Test
    @DisplayName("Test LIC9 for negative C_PTS")
    public void NegativeC_PTSTest() {

        Assertions.assertFalse(LIC9.LIC9(list, 10, -1, 2));
    }

    @Test
    @DisplayName("Test LIC9 for negative D_PTS")
    public void NegativeD_PTSTest() {

        Assertions.assertFalse(LIC9.LIC9(list, 5, 1, -1));
    }

    @Test
    @DisplayName("Test LIC9 for points coinciding with vertex")
    public void CoincidingPointsTest() {

        list = Arrays.asList(
            new Point(1, 1),
            new Point(0, 0),
            new Point(1, 1),
            new Point(0, 0),
            new Point(3, -5),
            new Point(0, 0)
                            );

        Assertions.assertFalse(LIC9.LIC9(list, 0.01, 1, 1));
    }
}