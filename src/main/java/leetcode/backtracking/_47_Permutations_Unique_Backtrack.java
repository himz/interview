package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * https://leetcode.com/problems/permutations-ii/
 * Solution: Explanation: https://www.youtube.com/watch?v=A3ge2mdQi4g
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
// Permutations
public class _47_Permutations_Unique_Backtrack {
    int N;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        N = nums.length;
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), result, new boolean[N]);
        return result;
    }

        // Optimization, track used numbers separated in used boolean array, will save contains call.
    void dfs(int[] nums, List<Integer> tmpPermuteList, List<List<Integer>> result, boolean [] used) {

        if(tmpPermuteList.size() == N) {
            result.add(new ArrayList<>(tmpPermuteList));
            return;
        }
        for(int i = 0; i < N; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            tmpPermuteList.add(nums[i]);
            dfs(nums, tmpPermuteList, result, used);
            // Backtracking, but this is brute force, all the possible solutions, as backtracking, is not pruning any trees here.
            tmpPermuteList.remove(tmpPermuteList.size() -1);
            used[i] = false;

            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}
