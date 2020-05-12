package leetcode.backtracking;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
// Backtracking N Queen

public class _51_NQueen_Backtracking {
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        List<List<String>> result = new ArrayList<>();
        int[][] arr = new int[n][n];
        for (int[] element : arr) {
            Arrays.fill(element, 0);
        }

        solveNQueenUtil(arr, 0, result);
        return result;
    }

    boolean isSafe(int[][] arr, int x, int y) {
        // basically, find if there are any Q in range of current Q.

        // Row check
        for (int i = 0; i < N; i++) {
            if (i != y && arr[x][i] == 1) {
                // collision
                return false;
            }
        }

        // column check
        for (int i = 0; i < N; i++) {
            if (i != x && arr[i][y] == 1) {
                // collision
                return false;
            }
        }

        // Diagonal 1 check

        /* Check upper diagonal on left side */
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1)
                return false;
        }

        /* Check lower diagonal on left side */
        for (int i = x, j = y; j >= 0 && i < N; i++, j--) {
            if (arr[i][j] == 1)
                return false;
        }

        return true;
    }

    List<String> constructBoard(int[][]arr) {
        List<String> result = new ArrayList<>();
        String str;
        for(int i = 0; i < N; i++) {
            str = new String();
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    str = str + 'Q';
                } else {
                    str = str +'.';
                }
            }
            result.add(str);
        }
        return result;
    }

    void solveNQueenUtil(int[][] arr, int col, List<List<String>> res) {
        if (col >= N) {
            // This is the final solution
            res.add(constructBoard(arr));
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(arr, i, col)) {
                // place the queen there
                arr[i][col] = 1;
                solveNQueenUtil(arr, col + 1, res);
                arr[i][col] = 0;
            }
        }
    }
}