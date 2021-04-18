package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * Medium
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 *
 *     The order of returned grid coordinates does not matter.
 *     Both m and n are less than 150.
 *
 *
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
// DFS solution
public class _417_PacificAtlanticWater_flood {

    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        boolean [][] pacific = new boolean[m][n];
        boolean [][] atlantic = new boolean[m][n];


        for(int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MAX_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MAX_VALUE, m-1, i);
        }

        for(int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MAX_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MAX_VALUE, i, n-1);
        }
        System.out.println(Arrays.deepToString(pacific));
        System.out.println(Arrays.deepToString(atlantic));
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j])
                    result.add(List.of(i,j));
            }
        }
        return result;

    }

    void dfs(int [][] matrix, boolean [][] visited, int height, int x, int y) {
        System.out.println("x: " + x + "y:" + y + " height: " +height);
        if(x < 0|| x >= m || y < 0|| y >= n || visited[x][y] || matrix[x][y] > height) {
            return;
        }

        visited[x][y] = true;

        dfs(matrix, visited, matrix[x][y], x + 1, y);
        dfs(matrix, visited, matrix[x][y], x - 1, y);
        dfs(matrix, visited, matrix[x][y], x, y + 1);
        dfs(matrix, visited, matrix[x][y], x, y - 1);

        return;
    }

}
