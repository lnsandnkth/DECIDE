import java.util.LinkedList;
import com.example.Point;
import java.util.List;
import java.util.Queue;
import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

public class ConditionCheck {

    private double PI = 3.1415926535;

    /*
     * LIC0 checks if there exists at least one set of two consecutive data points
     *  that are a distance greater than the length
     * */
    public boolean LIC0(List<Point> points, double length1) throws IllegalArgumentException {
        if (length1 < 0) {
            throw new IllegalArgumentException("Length should not be less than zero");
        }
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double distance = calDistance(p1, p2);
            if (distance > length1) {
                return true;
            }
        }
        return false;
    }
   

   
      
         /**
     * Computes the length / size / norm of a vector
     * @param p vector
     * @see Point
     * @return (double) length / size / norm of p
     */
    public static double calNorm(Point p) {

        return Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
    }

    /**
     * Checks if a point is inside (or on the border) of a circle centered on (0, 0)
     * @param p point
     * @param radius radius of the circle
     * @see Point
     * @return (boolean) true if Point p is inside (or on the border) of the circle
     */
    public static boolean isInCircle(Point p, double radius) {

        return calNorm(p) <= radius;
    }


    /**
     * LIC1 - Launch Interceptor Condition #1
     * Checks if there is a set of 3 consecutive points outside a circle in an ordered list of points
     * @param points List<Point> list of points to iterate on
     * @param radius radius of the circle outside of which the points must be
     * @return (boolean) true is there are 3 consecutive points outside the circle in the list
     */
    public static boolean LIC1(List<Point> points, double radius) {

        int max_consecutive = 0;

        int consecutive = 0;
        for (Point point : points) {
            if (!isInCircle(point, radius)) {
                consecutive++;
                max_consecutive = Math.max(consecutive, max_consecutive);
            } else
                consecutive = 0;
        }

        return max_consecutive >= 3;
    }
  
   /**
     * LIC2 checks if there is an angle in the second point of a triangle that consists of three consecutive points that
     * either is less than PI - epsilon or greater than PI + epsilon.
     *
     * @param points  a list of data points
     * @param epsilon a value for deviation
     * @return boolean
     */
    public boolean LIC2(List<Point> points, float epsilon)  {
        Queue<Point> pointQueue = new LinkedList<>();

        for (Point point : points) {
            pointQueue.add(point);
            if (pointQueue.size() == 3) {
                Point a = pointQueue.poll();
                Point b = pointQueue.poll();
                Point c = pointQueue.poll();
                pointQueue.add(b);
                pointQueue.add(c);
                double angleInB = calcAngleInPoint2(a, b, c);
                if (angleInB < (180 - epsilon) || angleInB > (180 + epsilon)) {
                    return true;
                }
            }
        }
        return false;
    }

    private double calcAngleInPoint2(Point p1, Point p2, Point p3) {
        double a2 = Math.pow(calDistance(p2, p3), 2);
        double b2 = Math.pow(calDistance(p1, p3), 2);
        double c2 = Math.pow(calDistance(p1, p2), 2);
        float a = (float) sqrt(a2);
        float c = (float) sqrt(c2);
        float angleInP2 = (float) acos((a2 + c2 - b2) / (2 * a * c));
        angleInP2 = (float) (angleInP2 * 180 / PI);
        return angleInP2;
    }

    public static double calDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));

    }
}
