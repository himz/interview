package leetcode.dp;

import common.TreeNode;

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

// Algo - Start from s and end e. THis substring is pallindromic, if s+1 and e-1 are pallindromic substring.
public class _5_LongestPallindromicSubString {
    public String longestPalindrome(String s) {
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
            dp[0][0] = false;
        //Print dp
        for(int i = 0; i < len + 1; i++) {
            for(int j = 0; j < len+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int maxLen = 0;
        int start = 1;
        // Iterate
        for(int i = len; i >0; i--) {
            for(int j = i+1; j < len+1; j++) {
                // Calculat dp
                if(s.charAt(i-1) == s.charAt(j-1)) {
                    if(j-1 <i +1) {
                        System.out.println("ji"+ j + " " + i);
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
                        System.out.println("New Max" + maxLen + " " + start);
                    }
                }
            }
        }

        // Print dp
        for(int i = 0; i < len + 1; i++) {
            for(int j = 0; j < len+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return s.substring(start - 1, start + maxLen);

    }

}