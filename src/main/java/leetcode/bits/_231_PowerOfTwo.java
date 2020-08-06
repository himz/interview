package leetcode.bits;

import java.util.HashSet;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 */
public class _231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) {
            return false;
        }
        while(n > 1) {
            if(n%2 == 1 && n != 1) {
                return false;
            }
            n = n >> 1;

        }
        return true;
    }

    /**
     * Best way.
     * n = 1000
     * n-1 = 0111
     * n & n-1 = 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwoMethod2(int n) {
       return n>0 &&  (n&(n-1)) == 0;
    }

    /**
     * Java Way
     */
    public boolean isPowerOfTwoMethod3(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}