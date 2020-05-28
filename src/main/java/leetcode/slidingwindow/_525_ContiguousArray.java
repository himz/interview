package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 *
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 *
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 *
 * https://leetcode.com/problems/contiguous-array/
 *
 * @SimilarQuestions: 325: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/?tab=Description
 *                          https://www.programcreek.com/2014/10/leetcode-maximum-size-subarray-sum-equals-k-java/
 */

public class _525_ContiguousArray {
    /**
     * Algo: 1) if 0, decrease sum by 1, if 1, increase sum by 1.
     *       2) If sum = 0, increase the current max Count.
     *       3) If sum does not already exist in map, then store it, and also the starting location of the sum.
     *       4) If sum exists, this implies end position of the sum. store the end position.
     *       5) Once all are processed, go over the map to make sure, there is no other end - start greater than max count.
     *       Here is the visual explanation for this problem: https://leetcode.com/problems/contiguous-array/discuss/99655/Python-O(n)-Solution-with-Visual-Explanation
     *
     *       This is my code. THere is optimization, where we do not need to store the end location.
     *
     *       Sliding Window with dynamic size & extra DS
     */
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxCount = 0;
        Map<Integer, StartEnd> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum = sum - 1;
            } else {
                sum = sum + 1;
            }
            if (sum == 0) {
                // That full array till here is 0 from start.
                maxCount = i + 1;
            }
            if(map.containsKey(sum)) {
                StartEnd se = map.get(sum);
                se.end = i;
                map.put(sum, se);
            } else {
                StartEnd se = new StartEnd();
                se.start = i;
                se.end = -1;
                map.put(sum, se);
            }
        }


        for(Integer i : map.keySet()) {
            StartEnd se = map.get(i);
            if(se.end >= 0 && se.end - se.start > maxCount) {
                maxCount = se.end - se.start;
            }
        }

        return maxCount;
    }
}

class StartEnd {
    int start;
    int end;
}