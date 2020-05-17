package leetcode.dp;

import java.util.Arrays;

/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 *
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 *
 *
 Example 1:

 Input: [1,-2,3,-2]
 Output: 3
 Explanation: Subarray [3] has maximum sum 3

 Example 2:

 Input: [5,-3,5]
 Output: 10
 Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

 Example 3:

 Input: [3,-1,2,-1]
 Output: 4
 Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

 Example 4:

 Input: [3,-2,2,-3]
 Output: 3
 Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

 Example 5:

 Input: [-2,-3,-1]
 Output: -1
 Explanation: Subarray [-1] has maximum sum -1



 Note:

 -30000 <= A[i] <= 30000
 1 <= A.length <= 30000


 */

// https://leetcode.com/problems/maximum-sum-circular-subarray/
// DP Solution
public class _918_MaxSubCircularArray {
    /**
     * Max sum of window ending at j => M(j) = max(M[j-1] + A(j), M(J))
     * https://people.cs.clemson.edu/~bcdean/dp_practice/
     *
     * Here, the solution is very similar to max sub arary problem, if we copy the first array, towards end of it,
     * thereby, taking care of the full array system.
     */
    public int maxSubarraySumCircular(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int alen = A.length;
        int[] nums = new int[alen* 2 -1];
        int nlen = nums.length;
        for(int i = 0; i < alen; i++) {
            nums[i] = A[i];
            if( i != alen -1) {
                nums[i + alen] = A[i];
            }
        }

        int[] dp = new int[nlen];
        int[] dp2 = new int[nlen];

        Arrays.fill(dp, Integer.MIN_VALUE);
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        int startWindow =0;
        int maxSum = nums[0];
        boolean flag2 = true;
        for(int j = 1; j < nums.length; j++) {
            int sum1 = nums[j];
            int sum2;
            if(flag2) {
                sum2 = dp[j - 1] + nums[j];
            } else {
                sum2 = dp2[j-1] + nums[j];
            }
            int sum;

            if(sum1 >= sum2) {
                sum = sum1;
                startWindow = j;
            } else {
                sum = sum2;
            }
            if(sum > maxSum) {
                maxSum = sum;
            }

            if(flag2) {
                dp[j] = sum;
            } else {
                dp2[j] = sum;
            }

            if(flag2 && j == (alen + startWindow -1) ) {
                //start a new window and store in dp2.
                dp[j] = sum;
                dp2[j] = nums[j];
                flag2 = false;
            }

        }

        return maxSum;
    }


}
