package leetcode.dfs;

/**
 * Given an m x n board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     m == board.length
 *     n = board[i].length
 *     1 <= m, n <= 200
 *     1 <= word.length <= 103
 *     board and word consists only of lowercase and uppercase English letters.
 * https://leetcode.com/problems/word-search/
 */
// DFS solution
public class _79_wordSearch_dfs_matrix {
    int m, n;
    public boolean exist(char[][] board, String word) {
        // find first occurence of starting letter
        if(board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        int i = 0,j =0;
        boolean flag = false;
        for(i = 0; i < m ; i++) {
            for(j = 0; j < n; j++) {
                flag = dfs(board, word.toCharArray(),0,i,j);
                if(flag) {
                    return true;
                }
            }
        }

        return flag;
    }

    boolean dfs(char[][] board, char[] word,int pos, int x, int y) {
        if(pos == word.length) {
            return true;
        }

        if(x<0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if(word[pos] != board[x][y]) {
            return false;
        }
        board[x][y] = '*';
        boolean flag =  dfs(board, word, pos + 1, x, y+1 ) || dfs(board, word, pos + 1, x, y -1 ) || dfs(board, word, pos + 1, x + 1, y ) || dfs(board, word, pos + 1, x - 1, y );

        board[x][y] = word[pos];
        return flag;

    }



}
