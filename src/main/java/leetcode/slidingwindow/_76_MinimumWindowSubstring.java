package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k.
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 *
 *     If there is no such window in S that covers all characters in T, return the empty string "".
 *     If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * To learn algo: https://medium.com/leetcode-patterns/leetcode-pattern-2-sliding-windows-for-strings-e19af105316b
 */

/**
 * Algo: Sliding window of dynamic size and auxillary ds
 */
public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }


        int counter = map.size();

        int begin = 0; int end = 0;

        int len = Integer.MAX_VALUE;
        int fbegin = 0; int fend = 0;
        // Expand loop
        while(end < s.length()) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) -1);
                if(map.get(c) == 0) {
                    counter--;

                }
            }
            if(counter == 0 && (end - begin) < len) {
                len = end - begin;
                fbegin = begin;
                fend = end;
            }



            // Shrink loop
            while(counter == 0) {
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0) {
                        counter++;
                    }
                }

                if((end - begin) < len) {
                    len = end - begin;
                    fbegin = begin;
                    fend = end;
                }

                begin++;

            }
            end++;
        }

        if(len == Integer.MAX_VALUE) return "";
        // Create a string from the begin to end;
        String result = s.substring(fbegin, fend +1);
        return result;
    }
}
