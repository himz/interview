package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Medium
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 16
 *     s contains only lowercase English letters.
 *
 *     https://leetcode.com/problems/palindrome-partitioning/
 */
public class _131_PalindromicPartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, new ArrayList<String>(), 0);
        return result;
    }

    /**
     * Dfs backtracking, but here bounding function is isPallindrome.
     * if so, we take the substring and add to the result.
     */
    void dfs(String s, List<List<String>> result, List<String> tmpList, int start) {
        if(start >= s.length()) {
            result.add(new ArrayList<String>(tmpList));
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                // its a pallindromic string
                tmpList.add(s.substring(start, i+1));
                dfs(s, result, tmpList, i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        char []ch = s.toCharArray();
        for(int i = start, j = end; i < j; i++, j--) {
            if(ch[i]!= ch[j]) {
                return false;
            }
        }
        return true;
    }

}