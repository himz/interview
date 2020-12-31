package leetcode.dp;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 * Note:
 *
 *     The input string length won't exceed 1000.
 * https://leetcode.com/problems/palindromic-substrings/
 * Similar: https://leetcode.com/problems/longest-palindromic-substring/
 */

// Algo - Start from s and end e. THis substring is pallindromic, if s+1 and e-1 are pallindromic substring.
public class _647_PalindromicSubStrings {
    public int countSubstrings(String s) {

        int len = s.length();

        if(len == 0) {
            return 0;
        }

        if(len == 1){
            return 1;
        }
        boolean dp[][] = new boolean[len +1][len + 1];

        // Init
        for(int i = 0; i < len +1; i++) {
            dp[0][i] = false;
            dp[i][i] = true;
        }

        int counter = 0;
        // Iterate
        for(int i = len; i >0; i--) {
            for(int j = i+1; j < len+1; j++) {
                // Calculat dp
                if(s.charAt(i-1) == s.charAt(j-1)) {
                    if(j-1 <i +1) {
                        //consecutive nos
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if(dp[i][j]) {
                    counter++;
                }
            }
        }
        return counter + len;
    }
}