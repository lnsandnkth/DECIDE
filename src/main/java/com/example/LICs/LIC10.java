package com.example.LICs;
import com.example.utils.Point;
import java.util.List;
import static com.example.utils.MathFunctions.isTriangleArea;
public class LIC10 {

    /**
     * LIC10 - Check if three points with consecutive intervening points between form a triangle with an area greather than AREA_1
     *
     * @param points List of Point objects
     * @param e_pts  Amount of consecutive intervening points between Point 1 and 2.
     * @param f_pts  Amount of consecutive intervening points between Point 2 and 3.
     * @param AREA_1 Area to be checked against the triangle area that the three points form.
     * @return True if there is three such points that they form an area greater than AREA_1, otherwise return false.
     */
    public static boolean LIC10(List<Point> points, int e_pts, int f_pts, double AREA_1) {
        int currentIndex = 0;
        if (points.size()<5 || !(e_pts >=1) || !(f_pts>=1) || !(e_pts+f_pts<=points.size()+3)) {
            return false;
        }

        while ((points.size()) - currentIndex > (e_pts + f_pts + 2)) {
            Point firstPoint = points.get(currentIndex);
            Point secondPoint = points.get(currentIndex + e_pts + 1);
            Point thirdPoint = points.get(currentIndex + e_pts + f_pts + 2);
            if (isTriangleArea(firstPoint, secondPoint, thirdPoint) > AREA_1) {
                return true;
            }
            currentIndex++;

        }

        return false;
    }
}
