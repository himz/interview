package leetcode.dp;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 *
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     1 <= coins.length <= 12
 *     1 <= coins[i] <= 231 - 1
 *     0 <= amount <= 104
 * https://leetcode.com/problems/coin-change/
 */
public class _322_CoinChange1 {
    /** Solution 1 - DP - Tabular
     */
    public int change(int amount, int[] coins) {
        // Always create a table with 1 extra row/colum(to handle base case)
        int [][] dp = new int[coins.length + 1][amount + 1];
        // Initialization
        // If coins are 0, then infinite amount will be needed to get to required amount value, hence max val.
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        // if amount is 0, 0 coins are needed for the amount.
        for(int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 0;
        }


        // DP logic - similar to recursion
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i-1]) {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount] == Integer.MAX_VALUE -1 ? -1 : dp[coins.length][amount];

    }
}
