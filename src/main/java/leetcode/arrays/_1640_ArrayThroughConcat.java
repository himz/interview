package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].
 *
 * Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [85], pieces = [[85]]
 * Output: true
 *
 * Example 2:
 *
 * Input: arr = [15,88], pieces = [[88],[15]]
 * Output: true
 * Explanation: Concatenate [15] then [88]
 *
 * Example 3:
 *
 * Input: arr = [49,18,16], pieces = [[16,18,49]]
 * Output: false
 * Explanation: Even though the numbers match, we cannot reorder pieces[0].
 *
 * Example 4:
 *
 * Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * Output: true
 * Explanation: Concatenate [91] then [4,64] then [78]
 *
 * Example 5:
 *
 * Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= pieces.length <= arr.length <= 100
 *     sum(pieces[i].length) == arr.length
 *     1 <= pieces[i].length <= arr.length
 *     1 <= arr[i], pieces[i][j] <= 100
 *     The integers in arr are distinct.
 *     The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
 *
 *     https://leetcode.com/problems/check-array-formation-through-concatenation/
 */
public class _1640_ArrayThroughConcat {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<Integer> hm1 = new ArrayList<>();

        for(int a : arr) {
            hm1.add(a);
        }

        for(int []a : pieces) {
            int loc;
            loc = hm1.indexOf(a[0]);
            if(loc == -1) {
                return false; // all elements must be present
            }
            for(int i = 0; i < a.length; i++) {
                //check if the values are same starting at this point
                if(loc >= arr.length) {
                    return false;
                }
                if(hm1.get(loc++) != a[i]) {
                    return false ;// even one failure is false
                }
            }
        }

        return true;

    }
}
