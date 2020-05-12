package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Solution: Problem is to find an exit criteria from infinite loop. We use set for this. If we get to a number which is already in the set,
 * it implies, this will be an infinite loop. So no point in testing further.
 */
public class _387_FirstUniqueChar {
    public int firstUniqChar(String s) {
        // Easy .. count of all the chars.

        int [] count = new int[26];
        Arrays.fill(count, 0);
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}