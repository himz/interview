package leetcode.heap.pq;

/**
 * 973. K Closest Points to Origin
 * Medium
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 *
 * Note:
 *
 *     1 <= K <= points.length <= 10000
 *     -10000 < points[i][0] < 10000
 *     -10000 < points[i][1] < 10000
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */

import java.util.PriorityQueue;

/**
 * Use heap to store the points. Using min heap.
 */
public class _973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0)
            return new int[1][2];
        int[][] result = new int[K][2];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.getKey(), b.getKey()));

        for(int i = 0; i < points.length;i++) {
            int distance = points[i][0]* points[i][0] + points[i][1] * points[i][1] ;
            pq.offer(new Pair(distance, i));
        }


        int counter = 0;

        while(K-- > 0) {
            Pair<Integer, Integer> p = pq.poll();
            result[counter][0] = points[p.getValue()][0];
            result[counter++][1] = points[p.getValue()][1];
        }


        return result;

    }
}
// Create pair class as IDE does not have java 9 (pair class was put in java 9 then removed)
class Pair<T,R> {
    T object1;
    R object2;

    Pair(T object1, R object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    T getKey() {
        return object1;
    }

    R getValue() {
        return object2;
    }
}