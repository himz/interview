package leetcode.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 * https://leetcode.com/problems/house-robber-ii/
 */

/**
 * DP Algo: dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
 *  Idea is like finding max of two linear houses, in one, first house is selected, in another it is not.
 *
 */
public class _213_HouseRobber2 {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(nums.length == 1) {
            return nums[0];
        }


        if(len == 2) {
            // only two items, return max of the two
            return Math.max(nums[0], nums[1]);
        }

        int left = robHelper(nums, 0, len - 2);
        int right = robHelper(nums,1, len -1);

        return Math.max(left, right);
    }


    public int robHelper(int[] nums, int s, int e) {

        int dp[] = new int[e - s + 1];

        if(nums[s] >= nums[s + 1]) {
            dp[0] = nums[s];
            dp[1] = nums[s];
        } else {
            dp[0] = nums[s];
            dp[1] = nums[s + 1];
        }

        for(int i = s + 2; i <= e; i++) {
            dp[i - s] = Math.max(dp[i-2-s] + nums[i], dp[i-1-s]);
        }

        return dp[e - s];
    }
}
