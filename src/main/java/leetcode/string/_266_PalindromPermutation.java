package leetcode.string;

import java.util.Arrays;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 *
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 *
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 *
 * https://leetcode.com/problems/palindrome-permutation/
 */
public class _266_PalindromPermutation {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        Arrays.fill(map, 0);
        char [] chrStr = s.toCharArray();

        for(char i : chrStr) {
            map[(int)i]++;
        }
        // if string length == even, all should be even. If string length odd, one element should be odd.
        if(s.length()%2 == 0) {
            for(int i = 0; i < 256;i++) {
                if(map[i] %2 != 0) {
                    return false;
                }
            }
        } else {
            boolean flag = false;
            // one should be odd
            for(int i = 0; i < 256;i++) {
                if(map[i] %2 != 0 && flag == false) {
                    flag = true;
                } else if(flag == true && map[i]%2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}