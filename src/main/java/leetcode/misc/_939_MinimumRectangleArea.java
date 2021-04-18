package leetcode.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 939. Minimum Area Rectangle
 * Medium
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 *
 *
 * Note:
 *
 *     1 <= points.length <= 500
 *     0 <= points[i][0] <= 40000
 *     0 <= points[i][1] <= 40000
 *     All points are distinct.
 *
 * https://leetcode.com/problems/minimum-area-rectangle/
 */
/**
 * Idea:
 * Select any two points, assume them to be diagonal. Check if corresponding y column values are present in the column
 * map. If yes, a reactangle can be formed.
 */
public class _939_MinimumRectangleArea {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int [] point : points) {
            Set<Integer> set = map.getOrDefault(point[0], new HashSet<>());
            set.add(point[1]);
            map.put(point[0], set);
        }

        int minArea = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            for(int j = i+1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 != x2 && y1 != y2) {
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                        minArea = Math.min(minArea, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                    }
                }
            }
        }


        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
