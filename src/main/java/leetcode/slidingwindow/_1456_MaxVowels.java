package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and an integer k.
 *
 * Return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are (a, e, i, o, u).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 * Example 4:
 *
 * Input: s = "rhythms", k = 4
 * Output: 0
 * Explanation: We can see that s doesn't have any vowel letters.
 *
 * Example 5:
 *
 * Input: s = "tryhard", k = 4
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 10^5
 *     s consists of lowercase English letters.
 *     1 <= k <= s.length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */

/**
 * Algo: Sliding window of dynamic size
 */
public class _1456_MaxVowels {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;
        int start = 0;
        int end = 0;
        // Create Map to hold the vowels
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        count = 0;
        while(end <s.length()) {

            if(map.containsKey(s.charAt(end))) {
                count++;
            }


            if(count > maxCount) {
                maxCount = count;
            }
            end++;
            if(end - start >= k) {
                if(map.containsKey(s.charAt(start))) {
                    count--;
                }
                start++;
            }


        }

        return maxCount;
    }
}
