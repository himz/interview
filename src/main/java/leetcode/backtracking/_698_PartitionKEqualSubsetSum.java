package leetcode.backtracking;

import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 *
 *
 * Note:
 *
 *     1 <= k <= len(nums) <= 16.
 *     0 < nums[i] < 10000.
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
// TODO NOT SOLVED YET
// TODO THis is a backtracking problem only, with some dp optimizations. Have to figure out all the subsets!
    // Not solved. TODO
public class _698_PartitionKEqualSubsetSum {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k ==1) {
            return true;
        }
        int sum = Arrays.stream(nums).sum();

        if(sum%k != 0) {
            return false;
        } else {
            Arrays.sort(nums);         // trick to reduce time complexity without memoization
            int t[][] = new int[nums.length + 1][(sum/2) +1];
            for(int i = 0; i < nums.length +1; i++) {
                Arrays.fill(t[i], -1);
            }
            System.out.println(sum);
            int kpTopDown = kpTopDown(nums.length, sum/k, nums);
            return kpTopDown == k;
        }
    }

    // Option 3: DP TopDown
    int kpTopDown(int n, int s, int[] nums) {
        boolean td[][] = new boolean[nums.length+1][s+1];
        for(int i = 0; i < nums.length +1; i++) {
            td[i][0] = true;
        }
        for(int j = 1; j < s + 1; j++) {
            td[0][j] = false;
        }

        int count = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if(nums[i-1] <= j) {
                    boolean newSet = td[i-1][j-nums[i-1]];
                    boolean oldSet = td[i-1][j];
                    td[i][j] = newSet || oldSet;
                    if(j == s && newSet == true) {
                        // increase count
                        count++;
                    }
                } else {
                    td[i][j] = td[i-1][j];
                }
            }
        }
        // We have the table here now.
        // check the number of count
        System.out.println(count);
        return count;
    }
}
