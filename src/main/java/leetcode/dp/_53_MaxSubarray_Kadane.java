package leetcode.dp;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * https://leetcode.com/problems/maximum-subarray/
 */
// DP Solution
public class _53_MaxSubarray_Kadane {
    /**
     * Max sum of window ending at j => M(j) = max(M[j-1] + A(j), M(J))
     * https://people.cs.clemson.edu/~bcdean/dp_practice/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxSum = nums[0];
        for(int j = 1; j < nums.length; j++) {
            int sum1 = nums[j];
            int sum2 = dp[j-1] + nums[j];

            int sum = sum1>sum2 ? sum1:sum2;
            if(sum > maxSum) {
                maxSum = sum;
            }
            dp[j] = sum;
        }

        return maxSum;
    }


}
