package gfg;

import java.util.HashMap;

/**
 * Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, the maximum sum subarray is highlighted with blue rectangle and sum of this subarray is 29.
 *
 * Expected time complexity O(n)
 * https://www.geeksforgeeks.org/maximum-sum-submatrix/
 */
public class MaxSumSubRectangle {
    // return max sum of the rectangle
    // NOTE - code not run, but should be good for algo.
    int solve(int[][] arr) {
        // Write your code here
        int m = arr.length;
        int n = arr[0].length;
        int L = 0, R =0;
        int[] prefix = new int[m];
        int cSum = 0; int maxSum = 0;
        int cMSum = 0;
        for(int i = L; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(i == j) {
                        prefix[k] = arr[k][j];
                    } else {
                        prefix[k] = prefix[k] = arr[k][j];
                    }
                }
                // prefix array created, do something about it. Kadane
                cSum = prefix[0]; cMSum = prefix[0];
                for(int k = 1; k < m; k++) {
                    cSum = cSum + prefix[k];
                    if(cSum <= 0) {
                        // start new window from 1+;
                        cSum = 0;
                    } else {
                        if(cSum > cMSum) {
                            cMSum = cSum;
                        }
                    }
                }

                if(cMSum > maxSum)
                    maxSum = cMSum;
            }
        }

        return maxSum;
    }
}
