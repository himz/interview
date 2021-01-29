package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * Medium
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 *
 *     https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class _442_FindDuplicatesInArray {
    /**
     * Algo: Cyclomatic sort - basically put the elements in their correct place. Tag them as visited
     * ANything which is not visited, are the duplicates.
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {

        for(int i = 0; i < nums.length;) {
            if(Math.abs(nums[i]) != i + 1) {
                // the number is not at right place -- swap
                int temp = nums[Math.abs(nums[i]) - 1];
                if(temp < 0) {
                    // already has been swapped - move the pointer
                    i++;
                    continue;
                }
                nums[Math.abs(nums[i]) - 1] = -nums[i];
                nums[i] = temp;
            } else {
                // it was at correct place
                if(nums[i] > 0) {
                    nums[i] = -nums[i];
                }
                i++;
            }
        }

        List<Integer> retList = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i]) == nums[i]) {
                // duplicate
                retList.add(nums[i]);
            }
        }

        return retList;
    }
}
