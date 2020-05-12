package leetcode;

import common.TreeNode;

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
public class _202_HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = n;
        while (set.add(sum) && sum != 1) {
            if(sum == 1 || sum == 7) {
                // Optimization, always lead to happy number
                return true;
            }

            if(sum == 4) {
                // Optimization, always ends in cycle
                return false;
            }

            String s = Integer.toString(sum);
            char[] c = s.toCharArray();
            sum = 0;
            for (int i = 0; i < c.length; i++) {
                int p = Character.getNumericValue(c[i]);
                sum = sum + p * p;
            }
        }

        if (sum == 1) {
            return true;
        } else {
            return false;
        }
    }
}