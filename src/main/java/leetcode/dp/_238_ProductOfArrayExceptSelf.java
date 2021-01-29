package leetcode.dp;

/**
 * 238. Product of Array Except Self
 * Medium
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 *     https://leetcode.com/problems/product-of-array-except-self/
 */

import java.util.Arrays;

/**
 * Algorithm: Create two arrays, left array contains product of left of values.
 * Right array contains right values.
 * - Idea is sliding window only. Reduce repetetions
 */
public class _238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length ==0) {
            return nums;
        }

        if(nums.length == 1) {
            return nums;
        }

        int []left = new int[nums.length];
        int []right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right,1);
        for(int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }


        int dp[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            dp[i] = left[i] * right[i];
        }

        return dp;

    }
}
