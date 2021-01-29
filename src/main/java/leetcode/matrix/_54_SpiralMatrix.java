package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Medium
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 10
 *     -100 <= matrix[i][j] <= 100
 * https://leetcode.com/problems/spiral-matrix/
 */


public class _54_SpiralMatrix {
    /**
     * This is simple algo here. We decide 4 directions, change direction when we need to. Simple simulation
     * - Mark the visited node.
     * Another approach would be, to go row,col, row, col wise, by updating the range for each row/column to run by.
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int dir = 1; // dir = 1 -> right; dir = 3 -> left; dir = 2 -> down; dir = 4 -> up
        int i = 0, j = 0;
        while(true) {
            if(matrix[i][j] == 101) {
                // invalid location, return
                return ans;
            }
            ans.add(matrix[i][j]);
            matrix[i][j] = 101; // visited
            int pi = i, pj = j;     // Prospective cells
            if(dir == 1) {
                // move left
                pj++;
            } else if(dir == 2) {
                pi++;
            } else if(dir == 3) {
                pj--;
            } else if(dir == 4) {
                pi--;
            }

            // change direction if invalid location is hit
            if(pi < 0 || pi >= m || pj < 0 || pj >= n || matrix[pi][pj] == 101 ) {
                //invalid move, change direction;
                dir++;
                if(dir == 5) {
                    dir = 1;
                }
                if(dir == 1) {
                    // move left
                    j++;
                } else if(dir == 2) {
                    i++;
                } else if(dir == 3) {
                    j--;
                } else if(dir == 4) {
                    i--;
                }
            } else {
                // its a valid move
                i = pi;
                j = pj;
            }

            // double check validity of i,j
            if(i<0 || i >=m || j < 0 || j>=n) {
                // invalid i
                return ans;
            }


        }
    }
}
