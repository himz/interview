package leetcode.dp;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 *
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 300
 *     1 <= arr[0].length <= 300
 *     0 <= arr[i][j] <= 1
 *
 *     https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

/**
 * Algorithm: Assume there is square ending at A[i][j](i.e. right bottom corner). This will indicate the number of squares
 * ending here. As it is a square, the number will also indicate max size of the square.
 *
 * Now, when analyzing any A[i][j], we can say that the sum at that location is minimum of all A[i-1][j] A[i-1][j-1] A[i][j-1] +1
 * We skip all the places where A[i][j] == 0 -- as no square can end there.
 *
 * REally good idea, good to remember
 */
public class _1277_SubMatrixCountDp {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int counter = 0;
        for(int i = 0; i < m;i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] > 0 && i > 0 && j >0){
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;

                }
                counter = matrix[i][j] + counter;
            }

        }

        return counter;
    }
}
