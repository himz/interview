package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 *
 * Note:
 *
 *     The input strings only contain lower case letters.
 *     The length of both given strings is in range [1, 10,000].
 *     https://leetcode.com/problems/permutation-in-string/
 */
// NOTE: This is same as 438, all anagrams
public class _567_PermutationsInString {

    public boolean checkInclusion(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        if (s2 == null || s2.length() == 0) {
            return false;
        }
        int[] pMap = new int[26];

        for (char c : s1.toCharArray()) {
            pMap[c - 'a']++;
        }

        int begin = 0, end = 0;
        int counter = s1.length();

        while (end < s2.length()) {

            if (pMap[s2.charAt(end) - 'a'] >= 1) {

                counter--;
            }
            pMap[s2.charAt(end) -'a']--;
            end++;


            if (counter == 0) {
                return true;
            }

            if (end - begin == s1.length()) {
                if(pMap[s2.charAt(begin) - 'a'] >= 0) {
                    counter++;

                }
                pMap[s2.charAt(begin) - 'a']++;
                begin++;
            }

        }

        return false;
    }
}
