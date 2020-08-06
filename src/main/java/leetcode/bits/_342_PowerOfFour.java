package leetcode.bits;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 *
 * Example 2:
 *
 * Input: 5
 * Output: false
 * https://leetcode.com/problems/power-of-four/
 */

// Similar to leetcode.bits._231_PowerOfTwo - Check for algo details
public class _342_PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && Integer.bitCount(num) == 1 && (Integer.numberOfTrailingZeros(num) % 2 ==0);
    }
}