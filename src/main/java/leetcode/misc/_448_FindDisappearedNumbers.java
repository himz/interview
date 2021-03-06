package leetcode.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Easy
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Similar: leetcode.misc._442_FindAllDuplicatesInArray
 */
public class _448_FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            // FInd the original location of the number in case all numbers were present
            int loc = Math.abs(nums[i]) -1;
            if(nums[loc] > 0) {
                nums[loc] = -nums[loc];
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >0) {
                res.add(i+1);
            }
        }

        return res;

    }
}
