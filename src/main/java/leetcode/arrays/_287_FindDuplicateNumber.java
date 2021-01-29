package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 287. Find the Duplicate Number
 * Medium
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:
 *
 * Input: nums = [1,1]
 * Output: 1
 *
 * Example 4:
 *
 * Input: nums = [1,1,2]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     2 <= n <= 3 * 104
 *     nums.length == n + 1
 *     1 <= nums[i] <= n
 *     All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *
 *
 *
 * Follow up:
 *
 *     How can we prove that at least one duplicate number must exist in nums?
 *     Can you solve the problem without modifying the array nums?
 *     Can you solve the problem using only constant, O(1) extra space?
 *     Can you solve the problem with runtime complexity less than O(n2)?
 *
 *     https://leetcode.com/problems/find-the-duplicate-number/
 */
public class _287_FindDuplicateNumber {
    /**
     * Algo: Cyclomatic sort - basically put the elements in their correct place. Tag them as visited
     * ANything which is not visited, are the duplicates.
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // multiple ways to do .

        // 1. cyclomatic -- put every one of the in its correct place.

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
        for(int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i]) == nums[i]) {
                // duplicate
                return nums[i];
            }
        }

        return 0;
        // Using tortoise hare method, run two pointers, find the intersection point for cycle.
    }
}
