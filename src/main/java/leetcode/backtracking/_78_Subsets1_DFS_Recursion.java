package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
// THis is a recursive only way to get the answer.
    // Using i/p o/p method. Draw decision tree, and then just code it out as the tree. Check Aditya Verma Course
public class _78_Subsets1_DFS_Recursion {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    void dfs(List<List<Integer>> res, int[] nums, List<Integer> output, int start) {

        // Add the output to result.  Subsets will always be at the leaf node, as the way we have coded.
        if(start >= nums.length) {
            res.add(output);
            return;
        }

        List<Integer> op1 = new ArrayList<Integer>(output);
        List<Integer> op2 = new ArrayList<Integer>(output);

        op2.add(nums[start]); // add number at start to output 2.

        start++; // Erase the top element from input.

        dfs(res, nums, op1, start);
        dfs(res, nums, op2, start);

    }
}