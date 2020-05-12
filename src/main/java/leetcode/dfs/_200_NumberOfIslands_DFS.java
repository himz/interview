package leetcode.dfs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * https://leetcode.com/problems/number-of-islands/
 */
// DFS solution
public class _200_NumberOfIslands_DFS {

    int rows = 0;
    int cols = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;
        }

        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j =0; j < cols; j++) {
                if(grid[i][j] == 1) {
                   dfs(grid, i, j);
                   count++;
                }
            }
        }
        return count;
    }

    private void dfs(char grid[][], int i, int j) {
        if(!isLocValid(i,j))
            return;
        if(grid[i][j] != 1)
            return;
        grid[i][j] = 0;
        dfs(grid, i, j+1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j-1);
        dfs(grid, i - 1, j);
        return;
    }

    private boolean isLocValid(int i, int j) {
        if(i >= rows || i < 0 || j >= cols || j < 0)
            return false;
        return true;
    }


}
