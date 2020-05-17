package leetcode.backtracking;

import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 * ]
 */
// Backtracking N Queen
public class _90_Subsets2_Duplicate_Backtracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    void dfs(List<List<Integer>> res, int[] nums, List<Integer> tmpList, int start) {

        res.add(new ArrayList<>(tmpList));

        for(int i = start; i < nums.length; i++) {
/*            if (tmpList.contains(nums[i])){
                continue;
            }*/

            tmpList.add(nums[i]);
            /// We do not want duplicates
            dfs(res, nums, tmpList, i + 1);
            tmpList.remove(tmpList.size() -1);
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }


    }
}