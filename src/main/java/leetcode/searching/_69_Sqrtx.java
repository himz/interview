package leetcode.searching;

/**
 * Implement int sqrt(int x). Compute and return the square root of x,
 * where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer
 * part of the result is returned.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 *
 * Input: 8
 * Output: 2
 */
public class _69_Sqrtx {

    // Square root is bound to be less than equal to x/2. We need to find first element, for which k^2 is greater than x.

    public int mySqrt(int x) {

        int start = 1;
        int end = x;

        while(start < end) {
            int mid = start + (end -start)/2;

            if(mid*mid >x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start -1;
    }
}
