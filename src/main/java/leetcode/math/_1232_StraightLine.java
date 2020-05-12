package leetcode.math;

/**
 * 1232. Check If It Is a Straight Line
 * Easy
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2:
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     2 <= coordinates.length <= 1000
 *     coordinates[i].length == 2
 *     -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 *     coordinates contains no duplicate point.
 */
public class _1232_StraightLine {
    /**
     * Solution 1: Why this works:
     * - Calculate slote of inital two values.
     * - Now calculate slope from first point to other points, one at a time. All slope should be equal
     *
     * Gotchas:
     * - int devision gives back int, even if we put that in double. So all should be double, or cast to double.
     * - devide by zero error works, because of double can handle NaN value. Double.compare gives true, on comparision
     *      of -Nan & +Nan. As such that case works
     *  - Have to handle case of + 0.0 vs -0.0, as compare will return false.
     *
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length <=2) {
            return true;
        }
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];
        double y2 = coordinates[1][1];
        double x2 = coordinates[1][0];
        double mGlobal = (y2 -y1)/(x2 - x1);
        for(int i = 2; i < coordinates.length; i++) {
            y2 = coordinates[i][1];
            x2 = coordinates[i][0];
            double mTemp = (y2 -y1)/(x2 - x1);
            if(mGlobal == 0.0 && mTemp == 0.0) {
                continue;
            }
            if(Double.compare(mGlobal, mTemp) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Avoid devision all together, by coverting to multiplication
     * (y3-y1)/(x3-x1) == (y2-y1)/(x2-x1)
     *
     * => (y3-y1) * (x2-x1) == (y2-y1) * (x3-x1)
     * This save division and above corner cases are automatically resoved.
     *
     */
    public boolean Sol2(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1],
                x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}
