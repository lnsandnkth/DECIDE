package ConditionTests;

import com.example.LICs.LIC14;
import com.example.utils.Point;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LIC14Test {
    List<Point> list;

    @BeforeEach
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
    @DisplayName("Test LIC14 for normal usage")
    public void NormalUsageCase(){
        Assertions.assertTrue(LIC14.LIC14(list, 1, 2, 1, 50));
    }

    @Test
    @DisplayName("Test LIC14 for smallest amount of points")
    public void FivePointTest() {
        list = Arrays.asList(
                new Point(0, 10),
                new Point(-2,6),
                new Point(0,0),
                new Point(-1, -3),
                new Point(5, -3));

        Assertions.assertTrue(LIC14.LIC14(list, 1, 1, 5, 100));
    }
    @Test
    @DisplayName("Test LIC14 for point 2, 4, 6")
    public void SixPointTest() {
        list = Arrays.asList(
                new Point(-2, 6),
                new Point(0,1),
                new Point(0,0),
                new Point(5, 5),
                new Point(0, 0),
                new Point(0, -7));

        Assertions.assertTrue(LIC14.LIC14(list, 2, 1, 3, 50));
    }
    @Test
    @DisplayName("Test LIC14 for too few points")
    public void FourPointTest() {
        list = Arrays.asList(new Point(0, 0), new Point(1, 1));

        Assertions.assertFalse(LIC14.LIC14(list, 1 ,3 ,5 , 15));
    }

    @Test
    @DisplayName("Test LIC14 for too big combination of E_PTS and K_PTS")
    public void EAndKCombinationTest(){
        list = Arrays.asList(
                new Point(-2, 6),
                new Point(0,1),
                new Point(0,0),
                new Point(5, 5),
                new Point(0, 0),
                new Point(0, -7));

        Assertions.assertFalse(LIC14.LIC14(list, 2, 2, 1, 300));
    }

    @Test
    @DisplayName("Test LIC14 for bad parameter range")
    public void BadParameterTest() {

        // AREA2 >= 0 is the only specified condition in DECIDE specification
        Assertions.assertFalse(LIC14.LIC14(list, 1, 1, 1, -1));
    }
}