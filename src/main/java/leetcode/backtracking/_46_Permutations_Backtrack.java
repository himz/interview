package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * https://leetcode.com/problems/permutations/
 * Solution: Explanation: https://www.youtube.com/watch?v=idmgLLNIC2U
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
// Permutations
public class _46_Permutations_Backtrack {
    int N;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        N = nums.length;
        dfs(nums, new ArrayList<>(), result);
        return result;
    }

        // Optimization, track used numbers separated in used boolean array, will save contains call.
    void dfs(int[] nums, List<Integer> tmpPermuteList, List<List<Integer>> result) {
        if(tmpPermuteList.size() == N) {
            result.add(new ArrayList<>(tmpPermuteList));
            System.out.println(result);
            return;
        }
        for(int i = 0; i < N; i++) {

            if(tmpPermuteList.contains(nums[i])) {
                continue;
            }
            tmpPermuteList.add(nums[i]);
            dfs(nums, tmpPermuteList, result);
            // Backtracking, but this is brute force, all the possible solutions, as backtracking, is not pruning any trees here.
            tmpPermuteList.remove(tmpPermuteList.size() -1);
        }
    }
}
