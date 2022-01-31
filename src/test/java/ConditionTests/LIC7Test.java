package ConditionTests;

import com.example.LICs.*;
import com.example.utils.Point;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIC7Test {

    @Test
    @DisplayName("LIC7 returning true test")
    public void LIC7TrueTest() {
        double LENGTH1True = 5.07;
        List<Point> trueList = Arrays.asList(
                new Point(8, 8),
                new Point(10, 4),
                new Point(-9, 5),
                new Point(-3, 0),
                new Point(2, 4),
                new Point(5, 5),
                new Point(-2, 1),
                new Point(10, 1),
                new Point(-7, 9),
                new Point(-3, 1)
        );

        Assertions.assertTrue(LIC7.LIC7(trueList, 1, LENGTH1True));
    }

    @Test
    @DisplayName("LIC7 returning false test")
    public void LIC7FalseTest(){
        double LENGTH1False = 1000;
        List<Point> falseList = Arrays.asList(
                new Point(2, -8),
                new Point(3, -6),
                new Point(-10, 9),
                new Point(-2, 3),
                new Point(-5, -8),
                new Point(5, -5),
                new Point(-1, 2),
                new Point(8, -9),
                new Point(1, 9),
                new Point(3, -5)
        );
        Assertions.assertFalse(LIC7.LIC7(falseList, 1, LENGTH1False));
    }

    @Test
    @DisplayName("LIC7 returning false on edge case test")
    public void LIC7EdgeCaseFalseTest(){
        List<Point> edgeCaseList = Arrays.asList(
                new Point(1,1),
                new Point(1,-1),
                new Point(-1,-1),
                new Point(-1, 1),
                new Point(0, 0)
        );

        Assertions.assertFalse(LIC7.LIC7(edgeCaseList, 1, 10));
    }


    @Test
    @DisplayName("LIC7 returning true on last point")
    public void LIC7LastPointTrueTest(){
        List<Point> list = Arrays.asList(
                new Point(-1, 0),
                new Point(0,0),
                new Point(0, 0),
                new Point(0, 5)
        );

        Assertions.assertTrue(LIC7.LIC7(list, 2, 3));
    }

    @Test
    @DisplayName("LIC7 empty list test")
    public void LIC7EmptyListTest(){
        List<Point> emptyList = new ArrayList<>();
        Assertions.assertFalse(LIC7.LIC7(emptyList, 1, 1));
    }

    @Test
    @DisplayName("LIC7 testing too large K_PTS")
    public void LIC7TooLargeK_PTSTest(){
        List<Point> list = new ArrayList<>();
        Assertions.assertFalse(LIC7.LIC7(list, 5, 100));
    }

    @Test
    @DisplayName("LIC7 testing too small K_PTS")
    public void LIC7TooSmallK_PTSTest(){
        List<Point> list = new ArrayList<>();
        Assertions.assertFalse(LIC7.LIC7(list, -1, 10));
    }

    @Test
    @DisplayName("LIC7 testing too small LENGTH1")
    public void LIC7TooSmallLENGTH1Test(){
        List<Point> list = new ArrayList<>();
        Assertions.assertFalse(LIC7.LIC7(list, 1, -1));
    }
}
