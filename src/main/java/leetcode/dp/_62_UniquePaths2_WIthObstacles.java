package leetcode.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 *
 *
 * Example 1:
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Example 2:
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     m == obstacleGrid.length
 *     n == obstacleGrid[i].length
 *     1 <= m, n <= 100
 *     obstacleGrid[i][j] is 0 or 1.
 *
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class _62_UniquePaths2_WIthObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];

        //Init the whole matrix with -1 as unknown entity
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                // no path from here - keep it at -1
                break;
            }
            dp[i][0] = 1;
        }


        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                // no path from here - keep it at -1
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                int left, right;
                if(obstacleGrid[i-1][j] == 1) {
                    left = 0;
                } else {
                    left = dp[i-1][j];
                }
                if(obstacleGrid[i][j-1] == 1) {
                    right = 0;
                } else {
                    right = dp[i][j-1];
                }

                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = left + right;
                }




            }
        }

        return dp[m-1][n-1];

    }
}
