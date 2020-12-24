package UniqueCodeToRemember;

import java.util.ArrayList;
import java.util.List;

/**
   *
 *https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 * https://leetcode.com/problems/permutations/
 * Solution: Explanation: https://www.youtube.com/watch?v=idmgLLNIC2U
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
// All possible repeated subsets
public class SubsetsGenericBacktrack {
    int N;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        N = nums.length;
        dfs(nums,  new ArrayList<>(), result, 0);
        return result;
    }

        // Optimization, track used numbers separated in used boolean array, will save contains call.
    void dfs(int[] nums, List<Integer> tmpList, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(tmpList));

        // COndition to get the permutations .. all possible.
        /*if(tmpPermuteList.size() == N) {
            result.add(new ArrayList<>(tmpPermuteList));
            return;
        }*/
        for(int i = start; i < N; i++) {
            // Remove repetetion/infinite loop.

            if(tmpList.contains(nums[i])) {
                continue;
            }
            tmpList.add(nums[i]);
            dfs(nums, tmpList, result, start + 1);
            // Backtracking, but this is brute force, all the possible solutions, as backtracking, is not pruning any trees here.
            tmpList.remove(tmpList.size() -1);
        }
    }
}
