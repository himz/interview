package leetcode.math;

import java.util.HashMap;

/**
 *  You are standing at position 0 on an infinite number line. There is a goal at position target.
 *
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 *
 * Return the minimum number of steps required to reach the destination.
 *
 * Example 1:
 *
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 *
 * Example 2:
 *
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 *
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9]
 * https://leetcode.com/problems/reach-a-number/
 */
// #Math XOR concept
public class _754_ReachANumber {
    // Math soln: ALgo
    /*
    keep incrementing steps, till we get to more than target.
    If step > target, && difference is even, return the answer. We can do that as if we flip a step, we get even difference.Like for 4, we can reach to 6 via 1 + 2 + 3. Just flirp 1 to - 1. Sum is 1 + 2 + 3 -(1+1) = 4.
    If step -target is odd, we need to make it even. Move again to next step or two. Now same logic will apply.
    */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int c = 1;
        while (step < target) {
            step = step + c++;
        }
        // If even, we are done. If odd, find even diff.

        while ((step - target) % 2 != 0) {
            step = step + c++;
        }

        return --c;
    }
}