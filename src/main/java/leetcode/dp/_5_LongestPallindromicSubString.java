package leetcode.dp;

import common.TreeNode;

import java.util.Arrays;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 *
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s consist of only digits and English letters (lower-case and/or upper-case),
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Similar: https://leetcode.com/problems/palindromic-substrings/
 */


public class _5_LongestPallindromicSubString {
    // Multiple ways, 2 dp, one recursive.
    public String longestPalindrome(String s) {
        return lpsUtil(s);
    }
    // Algo - Start from s and end e. THis substring is pallindromic, if s+1 and e-1 are pallindromic substring. --
    // most optimized
    String lpsDpSingleString(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len +1][len + 1];

        // Init
        for(int i = 0; i < len +1; i++) {
            dp[0][i] = false;

            for(int j = 0; j < i; j ++) {
                dp[i][j] = false;
            }
            dp[i][i] = true;
        }

        int maxLen = 0;
        int start = 1;
        // Iterate
        for(int i = len; i >0; i--) {
            for(int j = i+1; j < len+1; j++) {
                // Calculat dp
                if(s.charAt(i-1) == s.charAt(j-1)) {
                    if( j-1 < i + 1) {
                        //consecutive nos
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // Store the max len.
                if(dp[i][j]) {
                    // calculate distance from diagonal
                    if(j - i > maxLen) {
                        // THis is the new max
                        maxLen = j -i;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start - 1, start + maxLen);

    }

    String lpsUtil(String s) {
        StringBuffer s2 = new StringBuffer(s);
        s2.reverse();
        //int test = lpsRecursive(s, s2.toString(), s.length() -1, s2.length() -1 );
        String test = lpsDp(s, s2.toString());
        return test;
    }
    // this does not give the correct ans due to case mentioned in lpsdp
    int lpsRecursive(String s1, String s2, int i , int j) {


        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            // move the needle
            return lpsRecursive(s1, s2, i-1, j-1) +1;
        } else {
            // close the window
            return 0;
        }
    }
    // https://stackoverflow.com/questions/30752842/one-of-the-solution-for-finding-the-longest-palindromic-substring-could-not-be-u
    String lpsDp(String s1, String s2) {
        int len = s1.length();
        int dp[][] = new int[len +1][len + 1];
        Arrays.fill(dp[0], 0);
        // Init
        for(int i = 0; i < len + 1; i++) {
            for(int j = 0; j < len + 1; j ++) {
                dp[i][j] = 0;
            }
        }

        int maxLen = 0;
        int endi = 0;
        // Iterate
        for(int i = 1; i < s1.length() +1; i++) {
            for(int j = 1; j < s2.length() +1; j++) {
                // Calculat dp
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                } else {
                    dp[i][j] = 0;
                }
                // Store the max len.
                //https://stackoverflow.com/questions/30752842/one-of-the-solution-for-finding-the-longest-palindromic
                // -substring-could-not-be-u
                int revIdx = i;
                int forIdx = j - dp[i][j] + 1;

                if (len - revIdx + 1 == forIdx) {      // Here we check if the reverse string original idx is same as original string idx.
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        endi = i;
                    }
                }
            }
        }
        return s1.substring(endi - maxLen, endi);

    }

}