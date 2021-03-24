package leetcode.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 975. Odd Even Jump
 * Hard
 *
 * You are given an integer array A. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.
 *
 * You may jump forward from index i to index j (with i < j) in the following way:
 *
 *     During odd-numbered jumps (i.e., jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 *     During even-numbered jumps (i.e., jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 *     It may be the case that for some index i, there are no legal jumps.
 *
 * A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by jumping some number of times (possibly 0 or more than once).
 *
 * Return the number of good starting indices.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [10,13,12,14,15]
 * Output: 2
 * Explanation:
 * From starting index i = 0, we can make our 1st jump to i = 2 (since A[2] is the smallest among A[1], A[2], A[3],
 * A[4] that is greater or equal to A[0]), then we cannot jump any more.
 * From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
 * From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
 * From starting index i = 4, we have reached the end already.
 * In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of
 * jumps.
 *
 * Example 2:
 *
 * Input: A = [2,3,1,1,4]
 * Output: 3
 * Explanation:
 * From starting index i = 0, we make jumps to i = 1, i = 2, i = 3:
 *
 * During our 1st jump (odd-numbered), we first jump to i = 1 because A[1] is the smallest value in [A[1], A[2],
 * A[3], A[4]] that is greater than or equal to A[0].
 *
 * During our 2nd jump (even-numbered), we jump from i = 1 to i = 2 because A[2] is the largest value in [A[2], A[3],
 * A[4]] that is less than or equal to A[1]. A[3] is also the largest value, but 2 is a smaller index, so we can
 * only jump to i = 2 and not i = 3
 *
 * During our 3rd jump (odd-numbered), we jump from i = 2 to i = 3 because A[3] is the smallest value in [A[3], A[4]]
 * that is greater than or equal to A[2].
 *
 * We can't jump from i = 3 to i = 4, so the starting index i = 0 is not good.
 *
 * In a similar manner, we can deduce that:
 * From starting index i = 1, we jump to i = 4, so we reach the end.
 * From starting index i = 2, we jump to i = 3, and then we can't jump anymore.
 * From starting index i = 3, we jump to i = 4, so we reach the end.
 * From starting index i = 4, we are already at the end.
 * In total, there are 3 different starting indices i = 1, i = 3, and i = 4, where we can reach the end with some
 * number of jumps.
 *
 * Example 3:
 *
 * Input: A = [5,1,3,4,2]
 * Output: 3
 * Explanation:
 * We can reach the end from starting indices 1, 2, and 4.
 *
 *
 *
 * Constraints:
 *
 *     1 <= A.length <= 2 * 104
 *     0 <= A[i] < 105
 * https://leetcode.com/problems/odd-even-jump/
 * Related: https://leetcode.com/problems/sum-of-subarray-minimums/
 */

/**
 * Algo: Tough question. But idea is of that of monotone stack  - Find Next greater on Right etc.
 * As such put in stack package.
 */
public class _975_OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int n  = A.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
            if (hi != null) higher[i] = lower[(int)hi.getValue()];
            if (lo != null) lower[i] = higher[(int)lo.getValue()];
            if (higher[i]) res++;
            map.put(A[i], i);
        }
        return res;
    }

    // TLE answer
    public int oddEvenJumps2(int[] A) {
        int n = A.length -1;
        int [] ngr = getNgr(A) ;   // {1,3,3,4,-1};
        int [] nsr = getNsr(A);  //{-1,0,0,2,3};

        // start from 0
        int count = 0; int tc = 0; int j = 0;
        for(int i = 0; i < n; i++) {

            // check for i loop
            boolean jumpType = false; // false = even jump;
            j = i;
            while(true) {
                //odd jump
                if(jumpType) {
                    j = nsr[j];
                    jumpType = false;
                }
                else{
                    j = ngr[j];
                    jumpType = true;
                }
                tc++;
                if(j == n) {
                    // we reached end;
                    count++;
                    break;
                }

                if(j == -1){
                    // no path forward
                    break;
                }
            }
        }

        return count + 1; // include last one

    }


    int[] getNgr(int[] arr) {
        int [] result = new int[arr.length];
        Arrays.fill(result, -1);

        for(int i = arr.length - 2; i >=0; i--) {
            int max = Integer.MAX_VALUE; int maxLoc = -1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] >= arr[i]) {
                    if( max > arr[j]) {
                        max = arr[j];
                        maxLoc = j;
                    }
                }
            }
            result[i] = maxLoc;
        }
        return result;
    }


    int[] getNsr(int[] arr) {
        int [] result = new int[arr.length];
        Arrays.fill(result, -1);

        for(int i = arr.length - 2; i >=0; i--) {
            int max = Integer.MIN_VALUE; int maxLoc = -1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] <= arr[i]) {
                    if( max < arr[j]) {
                        max = arr[j];
                        maxLoc = j;
                    }
                }

            }
            result[i] = maxLoc;
        }
        return result;
    }


}