package leetcode.matrix;

/**
 * Medium
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 *     Any live cell with fewer than two live neighbors dies as if caused by under-population.
 *     Any live cell with two or three live neighbors lives on to the next generation.
 *     Any live cell with more than three live neighbors dies, as if by over-population.
 *     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * Example 2:
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 *
 * Constraints:
 *
 *     m == board.length
 *     n == board[i].length
 *     1 <= m, n <= 25
 *     board[i][j] is 0 or 1.
 *
 *
 *
 * Follow up:
 *
 *     Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 *     In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 * https://leetcode.com/problems/game-of-life/
 */


public class _289_GameOfLife {
    /**
     * Algo: This is naive implementation. To make it intereseting, we cannot use extra memory.
     * Keyfact: 8 neighbors. If i see 8, think of a byte. Store value of all active neighbors as byte array in each grid.
     * THis will be most efficient. Another could be, 10 implies 0. -10 implies 1. Now no. of neighbors is lsb. 11 - bit is 0, with 1 neighbor.
     */
    int m,n;
    public void gameOfLife(int[][] board) {
        // naive
        if(board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        int tmp[][] = new int[m][n];


        for(int i = 0; i < m;i++) {
            for(int j = 0; j  < n; j++) {
                if(board[i][j] == 0) {
                    // dead cell
                    int c = countLiveNeighbors(board, i, j);
                    if(c == 3) {
                        tmp[i][j] = 1;
                    } else {
                        tmp[i][j] = 0;
                    }
                } else {
                    // Live cell
                    int c = countLiveNeighbors(board, i, j);
                    if(c < 2 || c > 3) {
                        tmp[i][j] = 0;
                    } else {
                        tmp[i][j] = 1;
                    }
                }
            }
        }

        // copy tmp on to the board
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = tmp[i][j];
            }
        }
        return;
    }

    int countLiveNeighbors(int[][] grid,int x, int y) {
        int c = 0;

        for(int i = x-1; i <= x+1; i++) {
            for(int j = y-1; j <= y+1; j++) {
                if(i == x && j == y) {
                    continue;
                }
                if(isValid(i, j) && grid[i][j] == 1) {
                    c++;
                }
            }
        }
        return c;
    }

    boolean isValid(int x, int y) {
        if(x >= 0 && x < m && y>= 0 && y <n) {
            return true;
        } else {
            return false;
        }
    }
}
