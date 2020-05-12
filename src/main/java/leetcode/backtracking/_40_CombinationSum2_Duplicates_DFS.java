package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * https://leetcode.com/problems/combination-sum/
 *
 */
public class _40_CombinationSum2_Duplicates_DFS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, candidates, new ArrayList<>(), 0, target);
        return result;
    }

    void dfs(List<List<Integer>> result, int[] nums, List<Integer> tmpList, int start, int target) {

        if(target < 0){
            return;
        }
        if(0 == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i = start; i < nums.length; i++) {

            tmpList.add(nums[i]);
            // want duplicates
            dfs(result, nums, tmpList, i +1, target - nums[i]);
            tmpList.remove(tmpList.size() - 1);
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }

}