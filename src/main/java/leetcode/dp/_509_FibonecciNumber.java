package leetcode.dp;

/**
 * 509. Fibonacci Number
 * Easy
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 30
 *
 * https://leetcode.com/problems/fibonacci-number/
 */

/**
 * Fibonecci - recursive, memoized and bottom up
 */
public class _509_FibonecciNumber {
    int cache[];
    public int fib(int n) {
        if(n <= 1)
            return n;
        cache = new int[n +1];
        cache[0] = 0;
        cache[1] = 1;
        return fibRecur(n);
    }

    // Bottom up dp
    int fibIter(int n) {
        if(n <= 1)
            return n;
        int a = 0;
        int b = 1;
        int c = a + b;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
    // Recursive - Without memoization
    int fibRecur(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return fibRecur(n-1) + fibRecur(n-2);
    }

    // Bottom up - Memoized

    int fibRecurMemo(int n) {
        if(n == 0) {
            return 0;
        }

        if(cache[n] != 0)
            return cache[n];

        int sum1 = fibRecur(n-1);
        int sum2 = fibRecur(n-2);

        cache[n] = sum1 + sum2;
        return cache[n];
    }

}
