package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
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
// Backtracking N Queen
public class _78_Subsets1_DFS_Backtracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    void dfs(List<List<Integer>> res, int[] nums, List<Integer> tmpList, int start) {

        res.add(new ArrayList<>(tmpList));
        for(int i = start; i < nums.length; i++){
            tmpList.add(nums[i]);
            dfs(res, nums, tmpList,i + 1);
            tmpList.remove(tmpList.size() - 1);
        }

    }
}