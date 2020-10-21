package patterns.dp.kp;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 *     Each of the array element will not exceed 100.
 *     The array size will not exceed 200.
 *
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
// DP Solution
public class _416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if(sum%2 != 0) {
            return false;
        } else {
            Arrays.sort(nums);         // trick to reduce time complexity without memoization
            int t[][] = new int[nums.length + 1][(sum/2) +1];
            for(int i = 0; i < nums.length +1; i++) {
                Arrays.fill(t[i], -1);
            }
            System.out.println(sum);
            boolean kpFlag =  kp(nums.length, sum/2, nums);
            boolean kpTopDown = kpTopDown(nums.length, sum/2, nums, t);
            return kpMemo(nums.length, sum/2, nums, t);
        }
    }

    // Option 1Recursion without DP. Used a trick to let go of lot of cases. TODO Memoize!
    boolean kp(int n, int s, int[] nums) {
        if(s == 0) {
            return true;
        }

        if(n == 0) {
            return false;
        }

        boolean flag;
        if(nums[n-1] <= s) {

            flag = kp(n-1, s - nums[n-1], nums) || kp(n-1, s, nums);
        } else {
            flag = kp(n-1,s, nums) ;
        }

        return flag;
    }

    // Option 2: Memoize above - best
    boolean kpMemo(int n, int s, int[] nums, int t[][]) {
        if(s == 0) {
            return true;
        }

        if(n == 0) {
            return false;
        }
        System.out.println(n + "," +s);
        if(t[n][s] == 0) {
            return false;
        }

        if(t[n][s] == 1) {
            return true;
        }

        boolean flag;
        if(nums[n-1] <= s) {
            flag = kpMemo(n-1, s - nums[n-1], nums, t) || kpMemo(n-1, s, nums, t);
        } else {
            flag = kpMemo(n-1, s, nums, t) ;
        }

        if(flag == false) {
            t[n][s] = 0;
        } else {
            t[n][s] = 1;
        }
        return flag;
    }

    // Option 3: DP TopDown
    boolean kpTopDown(int n, int s, int[] nums, int t[][]) {
        boolean td[][] = new boolean[nums.length+1][s+1];
        for(int i = 0; i < nums.length +1; i++) {
            td[i][0] = true;
        }
        for(int j = 1; j < s + 1; j++) {
            td[0][j] = false;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if(nums[i-1] <= j) {
                    td[i][j] = td[i-1][j-nums[i-1]] || td[i-1][j];
                } else {
                    td[i][j] = td[i-1][j];
                }
            }
        }

        return td[nums.length][s];
    }


}
