package leetcode.greedy;

import java.util.Stack;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 3 * 104
 *     0 <= nums[i] <= 105
 *
 * https://leetcode.com/problems/jump-game/
 */

/**
 * Greedy Approach: start from end, if we can reach last, from one before, keep tracking, till we can reach from start.
 * Super simple, and works.
 */
public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int last = nums.length -1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= last) {
                last = i;
            }
        }

        if(last == 0) {
            return true;
        }

        return false;
    }
}
